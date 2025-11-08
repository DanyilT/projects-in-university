# University Repository Template

This template defines the complete, standardized folder structure and naming conventions for organizing university coursework across semesters, modules, and individual weeks.
It is designed to provide clarity, consistency, and scalability across all years of study.

Each part of this structure - `sem_template`, `module_template`, and `week_template` - provides a reusable skeleton that can be copied when creating new academic folders.

This documentation describes:
- folder structure at every level,
- allowed file and folder names,
- rules for lab, report, code, and mixed content,
- note-taking conventions,
- resource naming standards.

```
sem_template/
├── .gitkeep
└── module_template/
     ├── .gitkeep
     └── week_template/
          ├── .gitkeep
          ├── lab/
          │    ├── .gitkeep
          │    └── solution/
          │         └── .gitkeep
          ├── resources/
          │    ├── .gitkeep
          │    └── lecture/
          │         └── .gitkeep
          └── notes/
               └── .gitkeep
```

## 📁 Folder Structure

The template hierarchy consists of three core layers:

```
sem_template/
└── module_template/
     └── week_template/
          ├── lab/
          │    └── solution/
          ├── resources/
          │    └── lecture/
          └── notes/
```

### **Layer 1 — Semester Template**
```
semXX/
└── <module_name>/
```

### **Layer 2 — Module Template**
```
module_name/
├── week01/
├── week02/
├── assessment/
└── (optional extras: screenshots/, module_resources/)
```

### **Layer 3 — Week Template**
```
weekXX/
├── lab/
│    ├── <module>_weekXX_lab.pdf
│    └── solution/
│         └── (report/code/mixed)
├── resources/
│    └── lecture/
├── notes/
├── notes.md
└── README.md
```
[Read more in "Week Structure" section below.](#-week-structure)

### **Layer 3 — Assessment Template**
```
assessment/
└── 01/
     ├── <module>_assessment.pdf
     ├── submission/
     ├── resources/           (optional)
     ├── notes/               (optional)
     └── notes.md             (optional)
```
[Read more in "Assessment Structure" section below.](#-assessment-structure)

> [!WARNING]
> **Only create folders when required.**  
> Empty folders should **not** exist unless intentionally created using `.gitkeep` in templates.

## 🧾 General Naming Rules

Standard naming rules ensure clarity, sorting consistency, and compatibility across operating systems and Git.

---

### ✅ 1. Lowercase Only
All folder and file names must be **lowercase**.

✅ `cybersec_week01_lab.pdf`  
❌ `CyberSec_Week01_LAB.PDF`

---

### ✅ 2. Use Underscores `_`
Use `_` to separate words.  
Avoid spaces, hyphens, or camelCase.

✅ `week01_lab_report.pdf`  
❌ `week01-lab-report.pdf`  
❌ `Week01LabReport.pdf`

---

### ✅ 3. Week Number Consistency
Always use **two-digit week numbers**:

✅ `week01`, `week02`, ..., `week12`  
❌ `week1`, `Week2`, `wk12`

_This ensures proper sorting everywhere (GitHub, IDEs, file explorers)._

---

### ✅ 4. Module Prefix Required
Every lab/report file must begin with the **module full name**.

**Pattern:**
```
<module>*weekXX*<type>.ext
```
**Example:**
```
cybersec_week01_lab.pdf
cybersec_week01_lab_report.pdf
```

---

### ✅ 5. Context Comes From Path
Use **shorter filenames inside folders** where context is provided by directory structure.

**Example:**
```
week01/lab/solution/task1/main.py
```
**instead of:**
```
cybersec_week01_task1_main.py
```

---

### ✅ Folder Naming Rules
- All lowercase
- Use underscores if needed
- Avoid abbreviations unless module name is too long
- Use consistent patterns  

**Examples:**
```
sem05/
cybersec/
week01/
lab/submission/
resources/lecture/
notes/
assessment/
```

---

### ✅ File Naming Rules
File types follow strict patterns depending on their function.

#### **Lab Brief**
```
<module>_weekXX_lab.pdf
```

#### **Assessment Brief**
```
<module>_assessment.pdf
```

#### **Lab Report**
```
<module>_weekXX_lab_report.pdf
```

#### **Assessment Report**
```
<module>_assessment_report.pdf
```

#### **Code Files (short inside solution/)**
```
main.py
task1.py
task2_main.java
```

#### **Code Files (long, if outside solution/)**
```
cybersec_week01_lab_task1_solution.py
cybersec_week01_lab_main.c
```

#### **Resource Files**
```
lecture01_intro.pdf
example02_loops.py
reading01_network_security.pdf
```

#### **Notes (typed)**
```
notes.md
lecturenote01.md
labnote02.md
```

#### **Notes (images / photos)**
```
notes/lecturenote01.jpg
notes/labnote02_diagram.png
```

---

## 🗂 Week Structure
The week folder contains all materials for a specific week of a module.
[Folder structure is defined above.](#layer-3--week-template)

### 🧪 Lab Folder Structure and Naming
How to organize and name files inside the `lab/` folder.

#### 📄 Report-based Labs
Use this when the deliverable is a written report (e.g., in PDF or Markdown).

**Structure:**
```
lab/
├── <module>_weekXX_lab.pdf
└── solution/
     ├── <module>_weekXX_lab_report.pdf
     └── (supporting files, if any)
```
**Example:**
```
cybersec_week03_lab.pdf
cybersec_week03_lab_report.pdf
```

If need to include extra materials (data files, images, etc.), place them in a subfolder inside `solution/`, e.g.:
```
solution/resources/
solution/figures/
```

#### 💻 Code-based Labs
Use this when the lab requires programming tasks.

**Structure:**
```
lab/
├── <module>_weekXX_lab.pdf
└── solution/
     ├── (task folders or files)
     ├── README.md (optional: explain solution steps)
```
**If multiple tasks or questions:**
```
solution/
├── task1/
│    ├── main.py
│    ├── helper.py
│    └── README.md
├── task2/
│    ├── index.html
│    └── style.css
└── task3/
     └── query.sql
```
**If single or small codebase:**
```
solution/
├── main.py
├── requirements.txt
└── README.md
```
**File naming (if not in folders):**
| Case | Short name | Long name |
|-------|-------------|-----------|
| Single file | `main.py` | `cybersec_week01_lab_main.py` |
| Multi-part | `task1.py`, `task2.py` | `cybersec_week01_lab_task1_solution.py` |
| Helper file | `helper.py` | `cybersec_week01_lab_helper.py` |

Prefer **short names inside solution folders**, and **long descriptive names outside**.

#### 💻 Mixed Labs (Report + Code)
If both report and code are required, mix the patterns:

**Structure:**
```
lab/
├── <module>_weekXX_lab.pdf
└── solution/
     ├── report/
     │    └── <module>_weekXX_lab_report.pdf
     ├── code/
     │    ├── task1/
     │    └── task2/
     └── README.md
```

### 📚 Resources Folder
Resources are **optional** and may include lecture slides, PDFs, or reference material.

**Structure:**
```
resources/
├── lecture/
│    └── lectureXX_topic.pdf
├── examples/
│    └── example01_code.py
└── reading/
     └── paper01_author_year.pdf
└── resources.md (optional, summary of resources or links to external materials)
```
**Naming convention:**
| Type | Example | Description |
|------|----------|-------------|
| Lecture | `lecture01_intro_to_cybersec.pdf` | Lecture slides or presentations |
| Example | `example01_sql_injection.py` | Example code provided by lecturer |
| Reading | `reading01_networking_basics.pdf` | Extra reading materials |
| Dataset | `dataset01_students.csv` | Input/output for labs |

_Also if there is only some of reading resources, they can go directly under `resources/`. And name them as the `<resource_title>_<author>_<year>.ext`._

### 🗒️ Notes Naming
Notes can exist as a **Markdown file** or a **folder with handwritten/photo notes**.  
There are may also differentiate notes by topic type (lecture or lab).

### Folder-level examples:
```
notes/
├── lecturenote01.jpg
├── lecturenote02.jpg
├── labnote01.jpg
└── labnote02_diagram.png
```
### File-level examples:
```
notes.md            ← general or summary notes
lecturenote01.md    ← lecture-specific notes (typed)
labnote01.md        ← lab-specific notes (typed)
```
**Naming pattern:**
```
<note_type>note<XX>.<ext>
```
where `<note_type>` = `lecture` | `lab` | `revision` | `misc`

**Example:** `lecturenote01.md`, `labnote02.jpg`, `revisionnote03.md`

## 📔 Assessment Structure
The assessment folder contains all materials for a specific assessment of a module. Assessments follow the same logic as lab folders, but are stored at the module level.
[Folder structure is defined above.](#layer-3--assessment-template)

### 📁 Folder Structure
```
assessment/
└── 01/
     ├── <module>_assessment.pdf
     ├── submission/
     │    ├── <module>_assessment_report.pdf
     │    ├── code/                (if code deliverables)
     │    ├── project/             (if project deliverables)
     │    ├── project_link.txt     (if project hosted externally)
     │    └── (supporting files)
     ├── resources/                (optional)
     ├── notes/                    (optional)
     └── notes.md                  (optional)
```

### ✅ Naming Rules
- Folder numbering: `01`, `02`, ...
- No numbers in filenames
- Brief: `<module>_assessment.pdf`
- Report: `<module>_assessment_report.pdf`
- External project link stored in `project_link.txt`

### ✅ Types of Assessment Deliveries

#### 📄 Report-based
```
submission/
└── <module>_assessment_report.pdf
```

#### 💻 Code-based
```
submission/
└── code/
     ├── main.py
     └── ... (other code files)
```

#### 🗂 External Project (separate repo or branch)
```
submission/
└── project_link.txt
```

---
> [!TIP]
> If you ever need to quickly scaffold a new week, just copy the `/week_template` folder and rename it (`week01`, `week02`, etc.).
> 
> **How to do it?**
> ```bash
> cp -r templates/sem_template sem05
> ```
> ```bash
> cp -r templates/sem_template/module_template sem05/secure_programming
> ```
> ```bash
> cp -r templates/sem_template/module_template/week_template sem05/secure_programming/week01
> ```

---
_✍️ Copy Dany_
