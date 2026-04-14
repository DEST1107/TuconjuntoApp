function ProfileSection({ resident, reservationsCount, pendingPayments }) {
  return (
    <section className="app-section">
      <div className="section-head">
        <div>
          <p className="eyebrow">Perfil del residente</p>
          <h3>Resumen personal y operativo</h3>
        </div>
      </div>

      <div className="dashboard-grid">
        <article className="content-card profile-card">
          <div className="resident-avatar large">ND</div>
          <h3>{resident.nombres}</h3>
          <p>{resident.apartamento}</p>
          <p>{resident.correo}</p>
          <p>{resident.telefono}</p>
        </article>

        <article className="content-card">
          <div className="list-stack">
            <div className="summary-row">
              <span>Reservas registradas</span>
              <strong>{reservationsCount}</strong>
            </div>
            <div className="summary-row">
              <span>Pagos pendientes</span>
              <strong>{pendingPayments}</strong>
            </div>
            <div className="summary-row">
              <span>Estado del usuario</span>
              <strong>Activo</strong>
            </div>
            <div className="summary-row">
              <span>Rol funcional</span>
              <strong>Residente</strong>
            </div>
          </div>
        </article>
      </div>
    </section>
  );
}

export default ProfileSection;
