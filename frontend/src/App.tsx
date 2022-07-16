import Header from "./components/Header";
import SalesCard from "./components/SalesCard";

// Biblioteca para enviar a notificação para o navegador após enviar o SMS.
// Declaramos ele logo abaixo dentro do App e deixamos o projeto preparado para que em qualquer Component possamos chamar a mensagem de confirmação:
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

// Quando houver mais de um componente dentro do return, inseri-los dentro do fragment <> </>
function App() {
  return (
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  )
}

export default App;
