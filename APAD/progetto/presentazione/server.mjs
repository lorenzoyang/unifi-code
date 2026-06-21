import { createReadStream } from "node:fs";
import { access, stat } from "node:fs/promises";
import { createServer } from "node:http";
import path from "node:path";
import { fileURLToPath, pathToFileURL } from "node:url";

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const repoRoot = path.resolve(__dirname, "..");

const mimeTypes = {
  ".css": "text/css; charset=utf-8",
  ".csv": "text/csv; charset=utf-8",
  ".html": "text/html; charset=utf-8",
  ".js": "text/javascript; charset=utf-8",
  ".json": "application/json; charset=utf-8",
  ".map": "application/json; charset=utf-8",
  ".mjs": "text/javascript; charset=utf-8",
  ".pdf": "application/pdf",
  ".svg": "image/svg+xml",
  ".woff": "font/woff",
  ".woff2": "font/woff2"
};

function send(res, status, body, contentType = "text/plain; charset=utf-8") {
  res.writeHead(status, { "Content-Type": contentType });
  res.end(body);
}

export function createStaticServer(root = repoRoot) {
  const absoluteRoot = path.resolve(root);

  return createServer(async (req, res) => {
    try {
      const url = new URL(req.url ?? "/", "http://localhost");
      const pathname = decodeURIComponent(url.pathname);

      if (pathname === "/") {
        res.writeHead(302, { Location: "/presentazione/index.html" });
        res.end();
        return;
      }

      let requestedPath = path.resolve(absoluteRoot, `.${pathname}`);
      if (!requestedPath.startsWith(absoluteRoot)) {
        send(res, 403, "Forbidden");
        return;
      }

      const fileStat = await stat(requestedPath);
      if (fileStat.isDirectory()) {
        requestedPath = path.join(requestedPath, "index.html");
      }

      await access(requestedPath);
      const ext = path.extname(requestedPath).toLowerCase();
      res.writeHead(200, {
        "Content-Type": mimeTypes[ext] ?? "application/octet-stream"
      });
      createReadStream(requestedPath).pipe(res);
    } catch (error) {
      if (error?.code === "ENOENT") {
        send(res, 404, "Not found");
        return;
      }
      send(res, 500, String(error?.message ?? error));
    }
  });
}

export function listen(server, port = 0, host = "127.0.0.1") {
  return new Promise((resolve, reject) => {
    server.once("error", reject);
    server.listen(port, host, () => {
      server.off("error", reject);
      resolve(server.address());
    });
  });
}

if (
  typeof process !== "undefined" &&
  process.argv[1] &&
  import.meta.url === pathToFileURL(process.argv[1]).href
) {
  const port = Number(process.env.PORT ?? 4173);
  const server = createStaticServer();
  const address = await listen(server, port);
  console.log(`Presentazione disponibile su http://${address.address}:${address.port}/presentazione/index.html`);
}
