function SchedulesSection({ activeDay, onDayChange, schedules }) {
  const days = Object.keys(schedules);

  return (
    <section className="app-section">
      <div className="section-head">
        <div>
          <p className="eyebrow">Horarios</p>
          <h3>Disponibilidad de zonas comunes</h3>
        </div>
      </div>

      <div className="day-selector" role="tablist" aria-label="Filtrar horarios por dia">
        {days.map((day) => (
          <button
            key={day}
            className={`day-btn ${day === activeDay ? "active" : ""}`}
            onClick={() => onDayChange(day)}
            type="button"
          >
            {day}
          </button>
        ))}
      </div>

      <div className="schedule-grid">
        {schedules[activeDay].map((item) => (
          <article key={`${activeDay}-${item.title}`} className="schedule-card">
            <p className="eyebrow">Espacio comun</p>
            <h4>{item.title}</h4>
            <strong>{item.time}</strong>
            <p>{item.detail}</p>
          </article>
        ))}
      </div>
    </section>
  );
}

export default SchedulesSection;
