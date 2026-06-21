import { access, mkdir } from "node:fs/promises";
import path from "node:path";
import { fileURLToPath } from "node:url";
import { chromium } from "playwright-core";
import { createStaticServer, listen } from "./server.mjs";

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const outputPath = path.join(__dirname, "Yang.pdf");

async function firstExistingPath(paths) {
  for (const candidate of paths.filter(Boolean)) {
    try {
      await access(candidate);
      return candidate;
    } catch {
      // Try the next known browser path.
    }
  }
  throw new Error("Chrome/Edge non trovato. Imposta CHROME_PATH e rilancia npm run pdf.");
}

const executablePath = await firstExistingPath([
  process.env.CHROME_PATH,
  "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
  "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
  "C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe",
  "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"
]);

const server = createStaticServer();
const address = await listen(server, 0);
const url = `http://${address.address}:${address.port}/presentazione/index.html?print-pdf`;

let browser;
try {
  await mkdir(path.dirname(outputPath), { recursive: true });
  browser = await chromium.launch({ executablePath, headless: true });
  const page = await browser.newPage({ viewport: { width: 1600, height: 900 } });
  await page.goto(url, { waitUntil: "networkidle" });
  await page.waitForFunction(() => window.deckReady === true, null, { timeout: 30000 });
  await page.evaluate(() => document.fonts?.ready);
  await page.emulateMedia({ media: "print" });
  await page.pdf({
    path: outputPath,
    printBackground: true,
    preferCSSPageSize: true,
    width: "13.333in",
    height: "7.5in",
    margin: { top: "0", right: "0", bottom: "0", left: "0" }
  });
  console.log(`PDF generata: ${outputPath}`);
} finally {
  if (browser) {
    await browser.close();
  }
  server.close();
}
