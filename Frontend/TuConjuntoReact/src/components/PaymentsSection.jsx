function formatCurrency(value) {
  return new Intl.NumberFormat("es-CO", {
    style: "currency",
    currency: "COP",
    maximumFractionDigits: 0
  }).format(value);
}

function PaymentsSection({ payments, filter, onFilterChange }) {
  const pending = payments.find((payment) => payment.estado === "Pendiente");
  const filteredPayments =
    filter === "Todos" ? payments : payments.filter((payment) => payment.estado === filter);

  return (
    <section className="app-section">
      <div className="section-head">
        <div>
          <p className="eyebrow">Pagos y cartera</p>
          <h3>Estado de cuenta del residente</h3>
        </div>

        <div className="filter-group">
          <label htmlFor="payment-filter">Filtrar</label>
          <select id="payment-filter" value={filter} onChange={(event) => onFilterChange(event.target.value)}>
            <option>Todos</option>
            <option>Pendiente</option>
            <option>Pagado</option>
            <option>Acuerdo</option>
          </select>
        </div>
      </div>

      <div className="cards-inline">
        <article className="mini-panel alert-pending">
          <span className="mini-label">Cuota pendiente</span>
          <strong>{pending ? formatCurrency(pending.valor) : "$0"}</strong>
          <small>Vence el 30 de mayo</small>
        </article>
        <article className="mini-panel alert-ok">
          <span className="mini-label">Acuerdo de pago</span>
          <strong>Activo</strong>
          <small>2 cuotas restantes</small>
        </article>
        <article className="mini-panel alert-neutral">
          <span className="mini-label">Multas</span>
          <strong>0</strong>
          <small>No registras sanciones</small>
        </article>
      </div>

      <article className="content-card">
        <table className="data-table">
          <thead>
            <tr>
              <th>Concepto</th>
              <th>Periodo</th>
              <th>Valor</th>
              <th>Estado</th>
            </tr>
          </thead>
          <tbody>
            {filteredPayments.map((payment) => (
              <tr key={payment.id}>
                <td>{payment.concepto}</td>
                <td>{payment.periodo}</td>
                <td>{formatCurrency(payment.valor)}</td>
                <td>
                  <span className={`status-badge ${payment.estado.toLowerCase()}`}>{payment.estado}</span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </article>
    </section>
  );
}

export default PaymentsSection;
