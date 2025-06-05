# Clinical Decision Support for Obstructive Sleep Apnea (OSA) 

Artificial intelligence pipeline that turns evidence‑based **Obstructive Sleep Apnea (OSA)** guidelines into an executable, ontology‑driven *Clinical Decision Support System* (CDSS).  

The system blends **semantic reasoning** (OWL/RDF ontology + Jena rules) with **workflow automation** (YAWL, Petri nets) and a **modular Java application stack**.

## Key Features

- **Ontology‑centric knowledge model** — Protégé‑authored ontology (`1_Protege_Ontology/`) capturing OSA domain concepts, symptoms, diagnostics and treatments.  
- **Executable clinical workflow** — YAWL net (`3_YAWL_Workflow/OSA.yawl`).  
- **Rule‑based reasoning** — Java codelets implementing guideline rules.  
- **Pdf feature extraction** — From source PDFs and Composer assets to backups and datasets.

## Repository Layout

```text
0_Pdf/                  Original guidelines and clinical references  
1_Protege_Ontology/     OSA ontology (`.rdf`)  
2_Composer/             Model Composer project files  
3_YAWL_Workflow/        YAWL net, Java codelets, resources  
README.md               
```

## Quick Start

```bash
# 1. Clone
git clone https://github.com/your‑org/artificial_intelligence_project.git
cd artificial_intelligence_project

# 2. Open the YAWL engine
open http://localhost:8080/resourceService

# 3. Launch a Java client 
docker exec -it osa_app ./start.sh
```

## Architecture

```mermaid
flowchart TD
    subgraph Knowledge Layer
        OSA_Ontology[(OWL/RDF)]
        Rules[Jena Rules]
    end
    subgraph Workflow Layer
        YAWL_Engine((YAWL))
        Codelets{{Java Codelets}}
    end
    UI[Java/Swing GUI] -->|REST/JSON| Backend(:"OSA‑CDSS Service":)
    Backend -->|SPARQL| OSA_Ontology
    Backend -->|invoke| YAWL_Engine
    YAWL_Engine --> Codelets
    Codelets --> OSA_Ontology
```

##  Usage

1. **Populate patient data** either through the GUI or via the REST `/patients` endpoint.  
2. **Trigger evaluation** – the workflow determines applicable guideline steps.  
3. **Review recommendations** – suggested diagnostics/treatments are displayed along with links back to ontology assertions.  
4. **Persist or export** – results can be exported as HL7 FHIR resources for downstream EHR integration.

## Development

```bash
# Requirements
Java 17+ · Maven 3.9 

```

---

## Citation

If you use this toolkit for academic work, please cite:

```bibtex
@software{Artificial_Intelligence_Project,
  author  = {simonc999},
  title   = {Artificial_Intelligence_Project},
  year    = {2025},
  url     = {https://github.com/simonc999/Artificial_Intelligence_Project}
}
```

---
