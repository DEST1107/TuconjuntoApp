const sections = [
  { id: "inicio", label: "Inicio" },
  { id: "pagos", label: "Pagos" },
  { id: "reservas", label: "Reservas" },
  { id: "horarios", label: "Horarios" },
  { id: "noticias", label: "Noticias" },
  { id: "contacto", label: "Contacto" },
  { id: "perfil", label: "Perfil" }
];

function Sidebar({ activeSection, onNavigate }) {
  return (
    <aside className="sidebar">
      <div className="brand-card">
        <div className="brand-mark">TC</div>
        <div>
          <p className="eyebrow">Conjunto residencial</p>
          <h1 className="brand-title">TuConjunto React</h1>
          <p className="brand-copy">
            Modulo frontend del residente construido con React JS y enfocado en tareas frecuentes.
          </p>
        </div>
      </div>

      <nav className="side-nav" aria-label="Secciones principales">
        {sections.map((section) => (
          <button
            key={section.id}
            className={`nav-btn ${activeSection === section.id ? "active" : ""}`}
            onClick={() => onNavigate(section.id)}
            type="button"
          >
            {section.label}
          </button>
        ))}
      </nav>

      <div className="sidebar-note">
        <p className="eyebrow">Criterios aplicados</p>
        <ul className="check-list">
          <li>Jerarquia visual de acciones frecuentes del residente.</li>
          <li>Navegacion consistente, visible y enfocada en usabilidad.</li>
          <li>Informacion financiera, noticias y reservas en un mismo flujo.</li>
        </ul>
      </div>
    </aside>
  );
}

export default Sidebar;
