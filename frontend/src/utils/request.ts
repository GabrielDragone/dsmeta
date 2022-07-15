// Estamos exportando a BASE_URL para ser utilizada em outros lugares do sistema, sem ficarmos dessa forma repetindo código. 
// Utilizamos o operador ?? conhecido como Operador de Coalescência Nula. Do lado direito é o valor padrão da variável. 
// Porém, alternativamente, vai pegar o valor da variável de ambiente. Macete pra pegar o valor local caso ainda não tenhamos 
// configurado o projeto em algum lugar onde tenha o valor da variavel de ambiente:
export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";