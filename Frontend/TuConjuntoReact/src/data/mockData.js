export const resident = {
  id: 18,
  nombres: "Nazar Daniel",
  apartamento: "Torre B - Apto 302",
  estadoCuenta: "$120.000",
  proximaReserva: "18 mayo - Salon comunal",
  noticiasNuevas: 3,
  telefono: "3001112233",
  correo: "nazar@example.com"
};

export const payments = [
  { id: 1, concepto: "Administracion", periodo: "Mayo 2026", valor: 120000, estado: "Pendiente" },
  { id: 2, concepto: "Parqueadero", periodo: "Mayo 2026", valor: 45000, estado: "Pagado" },
  { id: 3, concepto: "Administracion", periodo: "Abril 2026", valor: 120000, estado: "Pagado" },
  { id: 4, concepto: "Cuota extraordinaria", periodo: "Marzo 2026", valor: 80000, estado: "Acuerdo" }
];

export const quickActions = [
  {
    id: "pagos",
    title: "Pagar administracion",
    description: "Consulta tu deuda, acuerdos de pago y novedades del mes."
  },
  {
    id: "reservas",
    title: "Reservar zona comun",
    description: "Solicita salon comunal, BBQ o cancha con fecha y horario."
  },
  {
    id: "horarios",
    title: "Ver horarios",
    description: "Revisa piscina, cancha multiple y gimnasio por jornada."
  },
  {
    id: "contacto",
    title: "Contactar administracion",
    description: "Accede a administradora, contador y porteria sin salir de la app."
  }
];

export const financeSummary = [
  { label: "Ingresos", value: "$18.400.000", progress: 84, type: "income" },
  { label: "Gastos", value: "$13.600.000", progress: 62, type: "expense" },
  { label: "Fondo disponible", value: "$4.800.000", progress: 36, type: "savings" }
];

export const schedules = {
  lunes: [
    { title: "Piscina", time: "6:00 a. m. - 10:00 a. m.", detail: "Adultos y nado libre" },
    { title: "Cancha multiple", time: "4:00 p. m. - 8:00 p. m.", detail: "Uso por bloques de 1 hora" }
  ],
  miercoles: [
    { title: "Gimnasio", time: "5:00 a. m. - 9:00 p. m.", detail: "Acceso con registro en porteria" },
    { title: "Salon social", time: "8:00 a. m. - 6:00 p. m.", detail: "Disponible para montaje de eventos" }
  ],
  sabado: [
    { title: "Piscina", time: "8:00 a. m. - 6:00 p. m.", detail: "Ingreso familiar por turnos" },
    { title: "Cancha multiple", time: "9:00 a. m. - 7:00 p. m.", detail: "Reservas activas desde la app" }
  ]
};

export const news = [
  {
    id: 1,
    title: "Mantenimiento preventivo de ascensores",
    category: "Administracion",
    date: "12 de abril de 2026",
    summary: "Se realizara mantenimiento por torres entre las 8:00 a. m. y las 12:00 m."
  },
  {
    id: 2,
    title: "Jornada de integracion del conjunto",
    category: "Comunidad",
    date: "10 de abril de 2026",
    summary: "La administracion invita a residentes y propietarios a la jornada del domingo."
  },
  {
    id: 3,
    title: "Reporte financiero del mes disponible",
    category: "Transparencia",
    date: "08 de abril de 2026",
    summary: "Ya puedes consultar ingresos, gastos y rubros de inversion del ultimo corte."
  }
];

export const contacts = [
  {
    id: 1,
    role: "Administradora",
    name: "Laura Gomez",
    phone: "3104456677",
    email: "administracion@tuconjunto.com"
  },
  {
    id: 2,
    role: "Contador",
    name: "Carlos Medina",
    phone: "3118854421",
    email: "contador@tuconjunto.com"
  },
  {
    id: 3,
    role: "Porteria",
    name: "Linea principal",
    phone: "6012234455",
    email: "porteria@tuconjunto.com"
  }
];

export const initialReservations = [
  {
    id: 1,
    area: "Salon comunal",
    date: "2026-05-18",
    time: "18:00",
    status: "Pendiente"
  },
  {
    id: 2,
    area: "Cancha multiple",
    date: "2026-05-22",
    time: "09:00",
    status: "Aprobada"
  }
];
