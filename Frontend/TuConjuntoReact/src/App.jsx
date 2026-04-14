import { startTransition, useEffect, useMemo, useState } from "react";
import Sidebar from "./components/Sidebar";
import Header from "./components/Header";
import DashboardSection from "./components/DashboardSection";
import PaymentsSection from "./components/PaymentsSection";
import ReservationsSection from "./components/ReservationsSection";
import SchedulesSection from "./components/SchedulesSection";
import NewsSection from "./components/NewsSection";
import ContactsSection from "./components/ContactsSection";
import ProfileSection from "./components/ProfileSection";
import {
  contacts,
  financeSummary,
  initialReservations,
  news,
  payments,
  quickActions,
  resident,
  schedules
} from "./data/mockData";

function App() {
  const [activeSection, setActiveSection] = useState("inicio");
  const [paymentFilter, setPaymentFilter] = useState("Todos");
  const [activeDay, setActiveDay] = useState("lunes");
  const [newsSearch, setNewsSearch] = useState("");
  const [reservations, setReservations] = useState(initialReservations);
  const [toast, setToast] = useState("");

  // Los datos se controlan localmente para sustentar el flujo del frontend
  // mientras el backend definitivo se integra en una fase posterior.
  const pendingPayments = useMemo(
    () => payments.filter((payment) => payment.estado === "Pendiente").length,
    []
  );

  const handleNavigate = (sectionId) => {
    startTransition(() => {
      setActiveSection(sectionId);
    });
  };

  const handleCreateReservation = (form) => {
    const newReservation = {
      id: Date.now(),
      area: form.area,
      date: form.date,
      time: form.time,
      status: "Pendiente"
    };

    setReservations((current) => [newReservation, ...current]);
    setToast("Solicitud enviada. Administracion revisara tu reserva.");
    handleNavigate("reservas");
  };

  useEffect(() => {
    if (!toast) {
      return undefined;
    }

    const timerId = window.setTimeout(() => {
      setToast("");
    }, 2800);

    return () => window.clearTimeout(timerId);
  }, [toast]);

  const content = {
    inicio: (
      <DashboardSection
        financeSummary={financeSummary}
        onNavigate={handleNavigate}
        quickActions={quickActions}
        resident={resident}
      />
    ),
    pagos: (
      <PaymentsSection
        filter={paymentFilter}
        onFilterChange={setPaymentFilter}
        payments={payments}
      />
    ),
    reservas: (
      <ReservationsSection
        onCreateReservation={handleCreateReservation}
        reservations={reservations}
      />
    ),
    horarios: (
      <SchedulesSection
        activeDay={activeDay}
        onDayChange={setActiveDay}
        schedules={schedules}
      />
    ),
    noticias: (
      <NewsSection news={news} onSearchChange={setNewsSearch} searchTerm={newsSearch} />
    ),
    contacto: <ContactsSection contacts={contacts} />,
    perfil: (
      <ProfileSection
        pendingPayments={pendingPayments}
        reservationsCount={reservations.length}
        resident={resident}
      />
    )
  };

  return (
    <div className="page-shell">
      <Sidebar activeSection={activeSection} onNavigate={handleNavigate} />

      <main className="main-content">
        <Header resident={resident} />
        {content[activeSection]}
      </main>

      {toast ? <div className="toast">{toast}</div> : null}
    </div>
  );
}

export default App;
