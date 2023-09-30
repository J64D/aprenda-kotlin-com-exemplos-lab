enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val htmlBasico = ConteudoEducacional("HTML Básico")
    val cssBasico = ConteudoEducacional("CSS Básico")
    val kotlinBasico = ConteudoEducacional("Kotlin Básico")

    // Criando uma formação
    val formacaoWeb = Formacao("Desenvolvimento Web", listOf(htmlBasico, cssBasico, kotlinBasico))

    // Criando alguns usuários
    val usuario1 = Usuario("Alice", Nivel.BASICO)
    val usuario2 = Usuario("Bob", Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Charlie", Nivel.AVANCADO)

    // Matriculando usuários na formação
    formacaoWeb.matricular(usuario1)
    formacaoWeb.matricular(usuario2)
    formacaoWeb.matricular(usuario3)

    // Exibindo usuários inscritos na formação
    println("Usuários inscritos na formação ${formacaoWeb.nome}:")
    for (usuario in formacaoWeb.inscritos) {
        println("- ${usuario.nome} (Nível: ${usuario.nivel})")
    }
}
