function ContactsSection({ contacts }) {
  return (
    <section className="app-section">
      <div className="section-head">
        <div>
          <p className="eyebrow">Canales de contacto</p>
          <h3>Administracion, contador y porteria</h3>
        </div>
      </div>

      <div className="contact-grid">
        {contacts.map((contact) => (
          <article key={contact.id} className="contact-card">
            <p className="eyebrow">{contact.role}</p>
            <h4>{contact.name}</h4>
            <p>{contact.phone}</p>
            <a href={`mailto:${contact.email}`}>{contact.email}</a>
          </article>
        ))}
      </div>
    </section>
  );
}

export default ContactsSection;
