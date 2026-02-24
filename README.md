# Stats with clojure

This project uses [Clay](https://scicloj.github.io/clay/) and [Quarto](https://quarto.org/) to generate documentation from Clojure notebooks.

## How to Build

To build all the Clojure notebooks in the `notebooks/` folder and generate Quarto files in the `docs/` folder, run:

```bash
clojure -M:build
```

This command will:
1. Scan the `notebooks/` directory for `.clj` files.
2. Use Clay to convert them into Quarto (`.qmd`) files in the `docs/` directory.
3. Automatically trigger a Quarto render to produce the final `.html` documentation.

## Prerequisites

- [Clojure CLI](https://clojure.org/guides/install_clojure)
- [Quarto](https://quarto.org/docs/get-started/) installed on your system path.
