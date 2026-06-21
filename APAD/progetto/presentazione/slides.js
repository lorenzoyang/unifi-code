import Reveal from "./node_modules/reveal.js/dist/reveal.esm.js";
import RevealNotes from "./node_modules/reveal.js/plugin/notes/notes.esm.js";

const fmtInt = new Intl.NumberFormat("it-IT", { maximumFractionDigits: 0 });
const fmtDec = new Intl.NumberFormat("it-IT", { minimumFractionDigits: 3, maximumFractionDigits: 3 });
const fmtPct = new Intl.NumberFormat("it-IT", { minimumFractionDigits: 2, maximumFractionDigits: 2 });

const datasetOrder = [
  "article",
  "book",
  "incollection",
  "inproceedings",
  "mastersthesis",
  "phdthesis",
  "proceedings"
];

const colors = ["#2563eb", "#0f766e", "#c2410c", "#15803d", "#6d28d9", "#b45309", "#be123c"];
const unionMarkdownYears = new Set([1960, 1980, 2000, 2010, 2020, 2023]);

function parseCsv(text) {
  const rows = [];
  let row = [];
  let cell = "";
  let insideQuotes = false;

  for (let i = 0; i < text.length; i += 1) {
    const char = text[i];
    const next = text[i + 1];

    if (char === '"' && next === '"') {
      cell += '"';
      i += 1;
    } else if (char === '"') {
      insideQuotes = !insideQuotes;
    } else if (char === "," && !insideQuotes) {
      row.push(cell);
      cell = "";
    } else if ((char === "\n" || char === "\r") && !insideQuotes) {
      if (char === "\r" && next === "\n") {
        i += 1;
      }
      row.push(cell);
      if (row.some((value) => value.length > 0)) {
        rows.push(row);
      }
      row = [];
      cell = "";
    } else {
      cell += char;
    }
  }

  if (cell.length > 0 || row.length > 0) {
    row.push(cell);
    rows.push(row);
  }

  const [header, ...body] = rows;
  return body.map((values) => Object.fromEntries(header.map((key, index) => [key, values[index] ?? ""])));
}

async function loadCsv(path) {
  const response = await fetch(path);
  if (!response.ok) {
    throw new Error(`Impossibile leggere ${path}`);
  }
  return parseCsv(await response.text());
}

function numberValue(row, key) {
  const value = Number(row[key]);
  return Number.isFinite(value) ? value : 0;
}

function datasetRank(name) {
  const rank = datasetOrder.indexOf(name);
  return rank === -1 ? datasetOrder.length : rank;
}

function htmlTable(headers, rows) {
  const headerHtml = headers
    .map((header) => `<th class="${header.numeric ? "numeric" : ""}">${header.label}</th>`)
    .join("");
  const bodyHtml = rows
    .map((row) => {
      const cells = headers
        .map((header) => `<td class="${header.numeric ? "numeric" : ""}">${row[header.key]}</td>`)
        .join("");
      return `<tr>${cells}</tr>`;
    })
    .join("");
  return `<table class="data-table"><thead><tr>${headerHtml}</tr></thead><tbody>${bodyHtml}</tbody></table>`;
}

function renderHorizontalBars(target, rows, options) {
  const width = options.width ?? 700;
  const left = options.left ?? 190;
  const right = options.right ?? 96;
  const rowHeight = options.rowHeight ?? 46;
  const height = 28 + rows.length * rowHeight;
  const max = options.max ?? Math.max(...rows.map((row) => row.value), 1);
  const barWidth = width - left - right;

  const bars = rows.map((row, index) => {
    const y = 24 + index * rowHeight;
    const w = Math.max(4, (row.value / max) * barWidth);
    const color = row.color ?? colors[index % colors.length];
    return `
      <text class="bar-label" x="0" y="${y + 20}">${row.label}</text>
      <rect x="${left}" y="${y}" width="${w}" height="24" rx="4" fill="${color}"></rect>
      <text class="bar-value" x="${left + w + 10}" y="${y + 19}">${row.display}</text>
    `;
  }).join("");

  target.innerHTML = `<svg viewBox="0 0 ${width} ${height}" role="img">${bars}</svg>`;
}

function renderLineChart(target, rows) {
  const width = 720;
  const height = 440;
  const pad = { top: 30, right: 36, bottom: 76, left: 82 };
  const years = rows.map((row) => numberValue(row, "year_limit"));
  const values = rows.map((row) => numberValue(row, "estimated_average_distance"));
  const minX = Math.min(...years);
  const maxX = Math.max(...years);
  const minY = Math.floor(Math.min(...values) - 1);
  const maxY = Math.ceil(Math.max(...values) + 1);
  const plotW = width - pad.left - pad.right;
  const plotH = height - pad.top - pad.bottom;

  const x = (year) => pad.left + ((year - minX) / (maxX - minX)) * plotW;
  const y = (value) => pad.top + (1 - (value - minY) / (maxY - minY)) * plotH;
  const points = rows.map((row) => [x(numberValue(row, "year_limit")), y(numberValue(row, "estimated_average_distance"))]);
  const path = points.map(([px, py], index) => `${index === 0 ? "M" : "L"} ${px} ${py}`).join(" ");
  const yearTicks = years.map((year) => ({
    value: year,
    xOffset: year === 2020 ? -18 : year === 2023 ? 18 : 0,
    yOffset: 0
  }));
  const yTicks = [6, 10, 14, 18];

  const grid = yTicks.map((tick) => `
    <line class="grid-line" x1="${pad.left}" y1="${y(tick)}" x2="${width - pad.right}" y2="${y(tick)}"></line>
    <text class="axis-label" text-anchor="end" x="${pad.left - 26}" y="${y(tick) + 6}">${tick}</text>
  `).join("");

  const labels = yearTicks.map((tick) => `
    <text class="axis-label" text-anchor="middle" x="${x(tick.value) + tick.xOffset}" y="${height - 22 + tick.yOffset}">${tick.value}</text>
  `).join("");

  const dots = rows.map((row, index) => {
    const [px, py] = points[index];
    const year = numberValue(row, "year_limit");
    const value = numberValue(row, "estimated_average_distance");
    const shouldLabel = index === 0 || index === rows.length - 1 || value === Math.max(...values);
    const labelText = value === Math.max(...values) ? `${year}: ${fmtDec.format(value)}` : fmtDec.format(value);
    const label = shouldLabel ? `<text class="bar-value" text-anchor="${value === Math.max(...values) ? "middle" : "start"}" x="${value === Math.max(...values) ? px : px - 24}" y="${py - 14}">${labelText}</text>` : "";
    return `${label}<circle class="chart-dot" cx="${px}" cy="${py}" r="7"></circle>`;
  }).join("");

  target.innerHTML = `
    <svg viewBox="0 0 ${width} ${height}" role="img">
      ${grid}
      <text class="axis-title" transform="translate(14 ${pad.top + plotH / 2}) rotate(-90)">distanza media stimata (archi)</text>
      <line class="axis-line" x1="${pad.left}" y1="${height - pad.bottom}" x2="${width - pad.right}" y2="${height - pad.bottom}"></line>
      <path class="chart-line" d="${path}"></path>
      ${dots}
      ${labels}
    </svg>
  `;
}

function renderQ1(rows) {
  const selected = rows
    .filter((row) => row.year_limit === "2023")
    .sort((a, b) => datasetRank(a.dataset) - datasetRank(b.dataset))
    .map((row) => ({
      dataset: row.dataset,
      author: row.author,
      solo: fmtInt.format(numberValue(row, "solo_publications"))
    }));

  document.querySelector("#q1-table").innerHTML = htmlTable(
    [
      { key: "dataset", label: "Dataset" },
      { key: "author", label: "Autore" },
      { key: "solo", label: "Singole", numeric: true }
    ],
    selected
  );

  const time = rows[0]?.execution_time_seconds;
  if (time) {
    document.querySelector("[data-field='q1-time']").textContent = `${fmtDec.format(Number(time))} s`;
  }
}

function renderQ3Size(rows) {
  const selected = rows
    .filter((row) => row.k === "512")
    .sort((a, b) => datasetRank(a.dataset) - datasetRank(b.dataset));

  document.querySelector("#q3-size-table").innerHTML = htmlTable(
    [
      { key: "dataset", label: "Dataset" },
      { key: "exact", label: "Esatto", numeric: true },
      { key: "estimate", label: "Stima", numeric: true },
      { key: "error", label: "Errore", numeric: true }
    ],
    selected.map((row) => ({
      dataset: row.dataset,
      exact: fmtInt.format(numberValue(row, "exact_distinct_authors")),
      estimate: fmtInt.format(numberValue(row, "estimated_distinct_authors")),
      error: `${fmtPct.format(numberValue(row, "relative_error") * 100)}%`
    }))
  );

  const bars = selected
    .map((row, index) => ({
      label: row.dataset,
      value: numberValue(row, "relative_error") * 100,
      display: `${fmtPct.format(numberValue(row, "relative_error") * 100)}%`,
      color: colors[index % colors.length]
    }))
    .sort((a, b) => b.value - a.value);
  renderHorizontalBars(document.querySelector("#q3-error-bars"), bars, { max: Math.max(...bars.map((row) => row.value), 1), left: 190, right: 90 });

  const time = rows[0]?.execution_time_seconds;
  if (time) {
    document.querySelector("[data-field='q3-time']").textContent = `${fmtDec.format(Number(time))} s`;
  }
}

function renderQ3Jaccard(rows) {
  const preferred = new Set([
    "article|inproceedings",
    "incollection|inproceedings",
    "article|phdthesis",
    "book|incollection"
  ]);
  const selected = rows
    .filter((row) => row.k === "512" && preferred.has(`${row.dataset_a}|${row.dataset_b}`))
    .sort((a, b) => numberValue(b, "exact_jaccard") - numberValue(a, "exact_jaccard"));

  document.querySelector("#q3-jaccard-table").innerHTML = htmlTable(
    [
      { key: "pair", label: "Coppia" },
      { key: "exact", label: "Esatto", numeric: true },
      { key: "estimate", label: "Stima", numeric: true },
      { key: "error", label: "Err. ass.", numeric: true }
    ],
    selected.map((row) => ({
      pair: `${row.dataset_a} - ${row.dataset_b}`,
      exact: fmtDec.format(numberValue(row, "exact_jaccard")),
      estimate: fmtDec.format(numberValue(row, "estimated_jaccard")),
      error: fmtDec.format(numberValue(row, "absolute_error"))
    }))
  );
}

function renderQ4(rows) {
  const selected = rows
    .filter((row) => row.year_limit === "2023")
    .sort((a, b) => datasetRank(a.dataset) - datasetRank(b.dataset));

  document.querySelector("#q4-table").innerHTML = htmlTable(
    [
      { key: "dataset", label: "Dataset" },
      { key: "nodes", label: "Nodi", numeric: true },
      { key: "lcc", label: "Nodi LCC", numeric: true },
      { key: "distance", label: "Dist.", numeric: true }
    ],
    selected.map((row) => ({
      dataset: row.dataset,
      nodes: fmtInt.format(numberValue(row, "nodes")),
      lcc: fmtInt.format(numberValue(row, "largest_component_nodes")),
      distance: fmtDec.format(numberValue(row, "estimated_average_distance"))
    }))
  );

  const bars = selected
    .map((row, index) => ({
      label: row.dataset,
      value: numberValue(row, "estimated_average_distance"),
      display: fmtDec.format(numberValue(row, "estimated_average_distance")),
      color: colors[index % colors.length]
    }))
    .sort((a, b) => b.value - a.value);
  renderHorizontalBars(document.querySelector("#q4-distance-bars"), bars, { max: Math.max(...bars.map((row) => row.value), 1), left: 190, right: 82 });
}

function renderUnion(rows) {
  const selected = rows
    .filter((row) => unionMarkdownYears.has(numberValue(row, "year_limit")))
    .sort((a, b) => numberValue(a, "year_limit") - numberValue(b, "year_limit"));
  const last = selected[selected.length - 1];
  const first = selected[0];
  document.querySelector("#union-metrics").innerHTML = `
    <div class="metric"><span>${fmtInt.format(numberValue(last, "nodes"))}</span><small>nodi nel 2023</small></div>
    <div class="metric"><span>${fmtInt.format(numberValue(last, "largest_component_nodes"))}</span><small>nodi LCC nel 2023</small></div>
    <div class="metric"><span>${fmtDec.format(numberValue(first, "estimated_average_distance"))} -> ${fmtDec.format(numberValue(last, "estimated_average_distance"))}</span><small>distanza media stimata</small></div>
  `;
  renderLineChart(document.querySelector("#union-line"), selected);
}

function renderAuthor(row) {
  document.querySelector("#author-card").innerHTML = `
    <div class="label">Coppia con piu' collaborazioni</div>
    <div class="pair">${row.author_a}<br>${row.author_b}</div>
    <div class="big-number">${fmtInt.format(numberValue(row, "collaborations"))}</div>
    <div class="label">pubblicazioni insieme</div>
    <div class="meta">
      <div><strong>${fmtInt.format(numberValue(row, "author_graph_nodes"))}</strong>nodi autori</div>
      <div><strong>${fmtInt.format(numberValue(row, "author_graph_edges"))}</strong>archi collaborazione</div>
    </div>
  `;
}

function renderTimings({ q1, q3, q4, union, author }) {
  const total = numberValue(union[0], "question_5_total_execution_time_seconds");
  const rows = [
    { label: "QUESTION 1.I", value: numberValue(q1[0], "execution_time_seconds"), color: "#2563eb" },
    { label: "QUESTION 3.I", value: numberValue(q3[0], "execution_time_seconds"), color: "#0f766e" },
    { label: "QUESTION 4.2", value: numberValue(q4[0], "execution_time_seconds"), color: "#c2410c" },
    { label: "Q5 totale", value: total, color: "#6d28d9" },
    { label: "Author graph", value: numberValue(author[0], "execution_time_seconds"), color: "#15803d" }
  ].map((row) => ({
    ...row,
    display: `${fmtDec.format(row.value)} s`
  }));

  renderHorizontalBars(document.querySelector("#timing-bars"), rows, { max: Math.max(...rows.map((row) => row.value)), left: 190, right: 128, rowHeight: 60 });
}

async function renderData() {
  const [q1, q3Size, q3Jaccard, q4, union, author] = await Promise.all([
    loadCsv("../results/question_1_i.csv"),
    loadCsv("../results/question_3_i_size.csv"),
    loadCsv("../results/question_3_i_jaccard.csv"),
    loadCsv("../results/question_4_2.csv"),
    loadCsv("../results/question_5_union_question_4_2.csv"),
    loadCsv("../results/question_5_author_collaboration.csv")
  ]);

  renderQ1(q1);
  renderQ3Size(q3Size);
  renderQ3Jaccard(q3Jaccard);
  renderQ4(q4);
  renderUnion(union);
  renderAuthor(author[0]);
  renderTimings({ q1, q3: q3Size, q4, union, author });
}

async function boot() {
  await renderData();
  const deck = new Reveal({
    width: 1600,
    height: 900,
    margin: 0.035,
    hash: true,
    slideNumber: "c/t",
    transition: "slide",
    backgroundTransition: "fade",
    plugins: [RevealNotes]
  });
  await deck.initialize();
  window.deckReady = true;
}

boot().catch((error) => {
  console.error(error);
  document.body.insertAdjacentHTML(
    "beforeend",
    `<pre style="position:fixed;inset:20px;z-index:9999;background:#fff;color:#b91c1c;padding:24px;border:2px solid #b91c1c;white-space:pre-wrap">${error.stack ?? error.message}</pre>`
  );
  window.deckReady = false;
});
