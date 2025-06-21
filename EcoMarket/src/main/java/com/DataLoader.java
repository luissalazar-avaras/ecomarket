/**kage com.ecomarket.ecomarket;
 * DataLoader es un componente que carga datos de ejemplo en la base de datos
 * cuando el perfil activo es "dev". Utiliza la librería Faker para generar datos
 * aleatorios de carreras, estudiantes, salas, tipos de sala y reservas.
 */ort org.springframework.beans.factory.annotation.Autowired;
@Profile("dev")ngframework.boot.CommandLineRunner;
@Component.springframework.context.annotation.Profile;
public class DataLoader implements CommandLineRunner {
    @Autowiredil.Date;
    private CarreraRepository carreraRepository;
    @Autowiredil.Random;
    EstudianteRepository estudianteRepository;
    @Autowired)
    private ReservaRepository reservaRepository;
    @AutowiredataLoader implements CommandLineRunner {
    private SalaRepository salaRepository;
    @AutowiredienteRepository clienteRepository;
    private TipoSalaRepository tipoSalaRepository;
    private CompraRepository compraRepository;
    /**towired
     * Método que se ejecuta al iniciar la aplicación. Genera y guarda datos de ejemplo
     * en la base de datos para facilitar el desarrollo y pruebas.
     */vate ProductoRepository productoRepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();) throws Exception {
        Random random = new Random();
        Random random = new Random();
        // Generar y guardar 3 tipos de sala aleatorios
        for (int i = 0; i < 3; i++) {
            TipoSala tipoSala = new TipoSala();
            tipoSala.setIdTipo(i + 1);poSala();
            tipoSala.setNombre(faker.book().genre());
            tipoSalaRepository.save(tipoSala);nre());
        }   tipoSalaRepository.save(tipoSala);
        }
        // Generar y guardar 5 carreras aleatorias
        for (int i = 0; i < 5; i++) {
            Carrera carrera = new Carrera();
            carrera.setCodigo(faker.code().asin());
            carrera.setNombre(faker.educator().course());
            carreraRepository.save(carrera);().course());
        }   carreraRepository.save(carrera);
        }
        List<Carrera> carreras = carreraRepository.findAll();
        List<Carrera> carreras = carreraRepository.findAll();
        // Generar y guardar 50 estudiantes aleatorios asociados a carreras
        for (int i = 0; i < 50; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(i + 1);new Estudiante();
            estudiante.setRun(faker.idNumber().valid());
            estudiante.setNombres(faker.name().fullName());
            estudiante.setCorreo(faker.internet().emailAddress());
            estudiante.setJornada(faker.options().option("D", "N").charAt(0));
            estudiante.setTelefono(faker.number().numberBetween(100000000, 999999999));
            estudiante.setCarrera(carreras.get(random.nextInt(carreras.size())));999));
            estudianteRepository.save(estudiante);dom.nextInt(carreras.size())));
        }   estudianteRepository.save(estudiante);
        }
        // Generar y guardar 10 salas aleatorias asociadas a tipos de sala
        for (int i = 0; i < 10; i++) {
            Sala sala = new Sala();) {
            sala.setCodigo(i + 1);;
            sala.setNombre(faker.university().name());
            sala.setCapacidad(faker.number().numberBetween(10, 100));
            sala.setIdInstituo(faker.number().randomDigit());, 100));
            sala.setTipoSala(tipoSalaRepository.findAll().get(random.nextInt(3)));
            salaRepository.save(sala);epository.findAll().get(random.nextInt(3)));
        }   salaRepository.save(sala);
        }
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<Sala> salas = salaRepository.findAll();ository.findAll();
        List<Sala> salas = salaRepository.findAll();
        // Generar y guardar 20 reservas aleatorias asociadas a estudiantes y salas
        for (int i = 0; i < 20; i++) {
            Reserva reserva = new Reserva();
            reserva.setId(i + 1); Reserva();
            reserva.setEstudiante(estudiantes.get(random.nextInt(estudiantes.size())));
            reserva.setSala(salas.get(random.nextInt(salas.size())));diantes.size())));
            reserva.setFechaSolicitada(new Date());t(salas.size())));
            reserva.setHoraSolicitada(new Date());;
            reserva.setHoraCierre(new Date(System.currentTimeMillis() +
                faker.number().numberBetween(3600000, 7200000))); // 1-2 horas más
            reserva.setEstado(faker.number().numberBetween(0, 2));// 1-2 horas más
            reservaRepository.save(reserva);.numberBetween(0, 2));
        }   reservaRepository.save(reserva);
    }   }
}   }
}
