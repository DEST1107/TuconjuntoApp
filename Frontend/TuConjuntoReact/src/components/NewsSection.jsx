import { useDeferredValue } from "react";

function NewsSection({ news, searchTerm, onSearchChange }) {
  const deferredSearch = useDeferredValue(searchTerm);
  const filteredNews = news.filter((item) => {
    const text = `${item.title} ${item.category} ${item.summary}`.toLowerCase();
    return text.includes(deferredSearch.trim().toLowerCase());
  });

  return (
    <section className="app-section">
      <div className="section-head">
        <div>
          <p className="eyebrow">Noticias</p>
          <h3>Informacion y novedades del conjunto</h3>
        </div>
      </div>

      <div className="content-card search-card">
        <label className="field full">
          <span>Buscar noticia o tema</span>
          <input
            type="search"
            value={searchTerm}
            onChange={(event) => onSearchChange(event.target.value)}
            placeholder="Ejemplo: ascensores, jornada, reporte financiero"
          />
        </label>
      </div>

      <div className="news-grid">
        {filteredNews.map((item) => (
          <article key={item.id} className="news-card">
            <p className="eyebrow">{item.category}</p>
            <h4>{item.title}</h4>
            <span className="news-date">{item.date}</span>
            <p>{item.summary}</p>
          </article>
        ))}
      </div>
    </section>
  );
}

export default NewsSection;
