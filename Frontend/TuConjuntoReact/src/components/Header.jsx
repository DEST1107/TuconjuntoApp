function Header({ resident }) {
  return (
    <header className="topbar">
      <div>
        <p className="eyebrow">Modulo codificado con React JS</p>
        <h2 className="topbar-title">Portal del residente</h2>
      </div>

      <div className="resident-pill">
        <div className="resident-avatar">ND</div>
        <div>
          <strong>{resident.nombres}</strong>
          <span>{resident.apartamento}</span>
        </div>
      </div>
    </header>
  );
}

export default Header;
