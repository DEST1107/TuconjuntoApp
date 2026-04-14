import { useState } from "react";

const initialForm = {
  area: "Salon comunal",
  date: "",
  time: "",
  detail: ""
};

function ReservationsSection({ reservations, onCreateReservation }) {
  const [form, setForm] = useState(initialForm);
  const [error, setError] = useState("");

  const handleChange = (field, value) => {
    setForm((current) => ({ ...current, [field]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Validacion simple del frontend para la evidencia academica.
    if (!form.date || !form.time) {
      setError("Debes seleccionar una fecha y una hora para la reserva.");
      return;
    }

    if (form.detail.trim().length < 8) {
      setError("Describe brevemente el motivo de la reserva con al menos 8 caracteres.");
      return;
    }

    onCreateReservation(form);
    setForm(initialForm);
    setError("");
  };

  return (
    <section className="app-section">
      <div className="section-head">
        <div>
          <p className="eyebrow">Zonas comunes</p>
          <h3>Reservas del residente</h3>
        </div>
      </div>

      <div className="dashboard-grid">
        <article className="content-card">
          <form className="form-grid" onSubmit={handleSubmit}>
            <div className="field">
              <label htmlFor="area">Area comun</label>
              <select id="area" value={form.area} onChange={(event) => handleChange("area", event.target.value)}>
                <option>Salon comunal</option>
                <option>Cancha multiple</option>
                <option>Zona BBQ</option>
              </select>
            </div>

            <div className="field">
              <label htmlFor="date">Fecha</label>
              <input id="date" type="date" value={form.date} onChange={(event) => handleChange("date", event.target.value)} />
            </div>

            <div className="field">
              <label htmlFor="time">Hora</label>
              <input id="time" type="time" value={form.time} onChange={(event) => handleChange("time", event.target.value)} />
            </div>

            <div className="field full">
              <label htmlFor="detail">Detalle</label>
              <textarea
                id="detail"
                rows="4"
                value={form.detail}
                onChange={(event) => handleChange("detail", event.target.value)}
                placeholder="Ejemplo: reunion familiar de maximo 20 personas."
              />
            </div>

            {error ? <p className="form-error">{error}</p> : null}

            <button className="btn btn-primary" type="submit">
              Registrar solicitud
            </button>
          </form>
        </article>

        <article className="content-card">
          <div className="section-head compact">
            <div>
              <p className="eyebrow">Historial</p>
              <h3>Solicitudes recientes</h3>
            </div>
          </div>

          <div className="list-stack">
            {reservations.map((reservation) => (
              <article key={reservation.id} className="reservation-card">
                <strong>{reservation.area}</strong>
                <span>
                  {reservation.date} - {reservation.time}
                </span>
                <small className={`status-badge ${reservation.status.toLowerCase()}`}>
                  {reservation.status}
                </small>
              </article>
            ))}
          </div>
        </article>
      </div>
    </section>
  );
}

export default ReservationsSection;
