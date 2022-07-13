import Header from "./components/Header";
import SalesCard from "./components/SalesCard";

// Quando houver mais de um componente dentro do return, inseri-los dentro do fragment <> </>
function App() {
  return (
    <>
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
