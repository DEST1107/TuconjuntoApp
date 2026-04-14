function DashboardSection({ resident, quickActions, financeSummary, onNavigate }) {
  return (
    <section className="app-section">
      <div className="hero-panel">
        <div>
          <p className="eyebrow">Panel principal</p>
          <h3>Todo lo importante del conjunto en un solo lugar</h3>
          <p className="hero-copy">
            El residente consulta pagos, noticias, reservas, horarios y contactos desde una sola
            interfaz web.
          </p>
          <div className="hero-actions">
            <button className="btn btn-primary" onClick={() => onNavigate("pagos")} type="button">
              Ver estado de cuenta
            </button>
            <button className="btn btn-secondary" onClick={() => onNavigate("reservas")} type="button">
              Reservar zona comun
            </button>
          </div>
        </div>

        <div className="hero-stats">
          <article className="metric-card highlight">
            <span className="metric-label">Saldo pendiente</span>
            <strong>{resident.estadoCuenta}</strong>
            <small>Administracion de mayo</small>
          </article>
          <article className="metric-card">
            <span className="metric-label">Noticias nuevas</span>
            <strong>{resident.noticiasNuevas}</strong>
            <small>Actualizadas esta semana</small>
          </article>
          <article className="metric-card">
            <span className="metric-label">Proxima reserva</span>
            <strong>18 mayo</strong>
            <small>{resident.proximaReserva}</small>
          </article>
        </div>
      </div>

      <div className="dashboard-grid">
        <article className="content-card">
          <div className="section-head">
            <div>
              <p className="eyebrow">Accesos rapidos</p>
              <h3>Tareas frecuentes del residente</h3>
            </div>
          </div>

          <div className="quick-grid">
            {quickActions.map((action) => (
              <button
                key={action.id}
                className="quick-card"
                onClick={() => onNavigate(action.id)}
                type="button"
              >
                <strong>{action.title}</strong>
                <span>{action.description}</span>
              </button>
            ))}
          </div>
        </article>

        <article className="content-card">
          <div className="section-head">
            <div>
              <p className="eyebrow">Resumen financiero</p>
              <h3>Estado general del conjunto</h3>
            </div>
          </div>

          <div className="finance-bars" aria-label="Balance resumido del conjunto">
            {financeSummary.map((item) => (
              <div key={item.label} className="bar-item">
                <span>{item.label}</span>
                <div className="bar-track">
                  <div className={`bar-fill ${item.type}`} style={{ width: `${item.progress}%` }} />
                </div>
                <strong>{item.value}</strong>
              </div>
            ))}
          </div>
        </article>
      </div>
    </section>
  );
}

export default DashboardSection;
