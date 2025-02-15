
<!doctype html>
<html lang="en">
    <head>
        <title>Base de datos</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/39f78fcbb4.js" crossorigin="anonymous"></script>
    </head>
    
    <body style="background-color: rgb(12, 39, 74); text-align: center;">
        <!-- Barra de navegación -->
        <nav
            class="navbar navbar-expand-sm navbar-dark bg-dark position-sticky top-0 start-0" style="z-index: 1000;"
        >
            <div class="container-fluid">
                <a class="navbar-brand" href="index.html"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Google_Earth_icon.svg/2048px-Google_Earth_icon.svg.png" alt="img" class="logo" style="width: 35px; height: 35px;"></a>
                <button
                    class="navbar-toggler d-lg-none"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavId"
                    aria-controls="collapsibleNavId"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav me-auto mt-2 mt-lg-0" style="align-items: center;">
                        <li class="nav-item">
                            <a class="nav-link active" href="index.html" aria-current="page"
                                >Inicio
                                <span class="visually-hidden">(current)</span></a
                            >
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about_us.php">Base de datos</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="dropdownId"  data-bs-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                                >Productos</a
                            >
                            <div
                                class="dropdown-menu"
                                aria-labelledby="dropdownId"
                            >
                                <a class="dropdown-item" href="index.html"
                                    >Categoría A</a
                                >
                                <a class="dropdown-item" href="index.html"
                                    >Categoría B</a
                                >
                            </div>
                        </li>
                    </ul>
                    <form class="d-flex my-2 my-lg-0">
                        <input
                            class="form-control me-sm-2"
                            type="text"
                            placeholder="Buscar productos..."
                        />
                        <button
                            class="btn btn-secondary my-2 my-sm-0"
                            type="submit"
                        >
                            Buscar
                        </button>
                        
                    </form>
                    <a href="index.html"><i class='fas fa-shopping-cart' role="button" style='font-size:36px; color: rgb(208, 204, 204);margin-left: 10px;'></i></a>
                    <a href="#"><i class='fas fa-user-circle' role="button" style='font-size:36px; color: #cdc5c5; margin-left: 10px;' data-bs-toggle="modal" data-bs-target="#loginModal"></i></a>
                            
                </div>
            </div>
        </nav>
        
        
        <!-- Texto -->
        <h1 style="color: rgb(197, 211, 224);">BASE DE DATOOOOOOOS...</h1>
        
        <!-- Modal de Inicio de Sesión -->
        <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="loginModalLabel">Iniciar Sesión</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="mb-3">
                                <label for="email" class="form-label">Correo</label>
                                <div class="input-group mb-3">
                                    <span class="input-group-text"><i class="fa-solid fa-user"></i></span>
                                    <input type="email" class="form-control" id="email" placeholder="Ingresa tu correo" required>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Contraseña</label>
                                <div class="input-group mb-3">
                                    <span class="input-group-text"><i class="fa-solid fa-key"></i></span>
                                    <input type="password" class="form-control" id="password" placeholder="Ingresa tu contraseña" required>
                                </div>
                                <div class="mb-3 form-check">
                                    <input type="checkbox" class="form-check-input" id="rememberMe">
                                    <label class="form-check-label" for="rememberMe">Recordar</label>
                                </div>
                                <div style="text-align: center;">
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer justify-content-center">
                        <p>¿No tienes cuenta? <a href="#" role="button" data-bs-toggle="modal" data-bs-target="#registroModal">Regístrate aquí</a></p>
                    </div>
                </div>
            </div>
        </div>
        
        
        <!-- Modal de Registro de Usuarios -->
        <div class="modal fade" id="registroModal" tabindex="-1" aria-labelledby="registroModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="registroModalLabel">Registrarse</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="container">
                                <div class="row mb-3">
                                    <div class="col-6">
                                        <input type="text" class="form-control" placeholder="Nombre(s)" required>
                                    </div>
                                    <div class="col-6">
                                        <input type="text" class="form-control" placeholder="Apellidos" required>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <input type="email" class="form-control" placeholder="Tu correo electrónico" required>
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" placeholder="Contraseña" required>
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" placeholder="Confirmar contraseña" required>
                            </div>
                            <div style="text-align: center;">
                                <button type="submit" class="btn btn-success">Registrarse</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Base de datos -->
        <div class="table" style="background-color: rgb(47, 115, 100); width: 80%; border-radius: 20px;" tabindex="-1" aria-labelledby="registroModalLabel">
            <div class="container">
                <div class="add-person">
                    <h5>Registrar persona</h5>

                    <form method="post">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre(s)" required>
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Apellidos" required>
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" id="dirección" name="dirección" placeholder="Tu dirección" required>
                        </div>
                        <div class="mb-3">
                            <input type="number" class="form-control" id="edad" name="edad" placeholder="Tu edad" value="18" min="18" required>
                        </div>
                        <div style="text-align: center;">
                            <button type="submit" class="btn btn-success" name="registrar">Registrarse</button>
                        </div>
                    </form>
                    <?php
                        if (isset($_POST['registrar'])) {
                            try {
                                $nombre = $_POST['nombre'];
                                $apellidos = $_POST['apellidos'];
                                $dirección = $_POST['dirección'];
                                $edad = $_POST['edad'];

                                $objetoPDO = new PDO('mysql:host=localhost; dbname=basededatosnueva', 'usuario', 'passwordnuevo');

                                $query = "INSERT INTO personas (nombre, apellidos, dirección, edad) VALUES (?, ?, ?, ?)";
                                $sth = $objetoPDO->prepare($query);
                                $resultado = $sth->execute([$nombre, $apellidos, $dirección, $edad]);

                                if ($resultado) {
                                    echo "<p>Persona agregada correctamente.</p>";
                                } else {
                                    echo "<p>Error al agregar persona, revisa los datos.</p>";
                                }
                            } catch (PDOException $e) {
                                echo "<p>¡Error!: " . $e->getMessage() . "</p>";
                            }
                        }
                    ?>
                </div>
                <div class="consult-person">
                    <h2>Consulta de Personas</h2>
                    <form method="post">
                        <input type="submit" name="consultar" value="Consultar" class="btn-submit">
                    </form>

                    <?php
                    if (isset($_POST['consultar'])) {
                        try {
                            $objetoPDO = new PDO('mysql:host=localhost; dbname=basededatosnueva', 'usuario', 'passwordnuevo');
                            $query = "SELECT * FROM personas";
                            $sth = $objetoPDO->prepare($query);
                            $resultado = $sth->execute();

                            if ($resultado) {
                                $array_filas = $sth->fetchAll();
                                if (count($array_filas) > 0) {
                                    echo "<table>";
                                    echo "<tr><th>Nombre</th><th>Apellidos</th><th>Dirección</th><th>Edad</th></tr>";
                                    foreach ($array_filas as $fila_usuario) {
                                        echo "<tr>";
                                        echo "<td>" . $fila_usuario['nombre'] . "</td>";
                                        echo "<td>" . $fila_usuario['apellidos'] . "</td>";
                                        echo "<td>" . $fila_usuario['dirección'] . "</td>";
                                        echo "<td>" . $fila_usuario['edad'] . "</td>";
                                        echo "</tr>";
                                    }
                                    echo "</table>";
                                } else {
                                    echo "<p>No hay personas registradas.</p>";
                                }
                            } else {
                                echo "<p>La consulta ha producido un error, revísala.</p>";
                            }
                        } catch (PDOException $e) {
                            echo "<p>¡Error!: " . $e->getMessage() . "</p>";
                        }
                    }
                    ?>
                </div>
            </div>
        </div>
    </body>
</html>