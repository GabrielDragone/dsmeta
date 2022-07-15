import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import NotificationButton from '../NotificationButton';

import "react-datepicker/dist/react-datepicker.css";
import './styles.css';
import axios from "axios";
import { BASE_URL } from "../../utils/request";
import { Sale } from "../../models/sale";

function SalesCard() {

    // Função pra pegar a data de 1 ano atrás:
    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date(); // Data de hoje.

    // Declaração de dado composto, onde temos o dado (minDate) e a função que muda o dado (setMinDate) que usaremos para alterar o dado:
    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    // Buscou através do useEffect os dados do endpoint e armazena dentro de sales:
    const [sales, setSales] = useState<Sale[]>([]);

    // useEffect: Serve para executar algo qnd o componente é montado ou quando o dado alterar.
    // Uma função como primeiro argumento e uma lista no segundo.
    useEffect(() => {
        console.log("TESTE (Faz 2x por estar em ambiente de teste):");
        // Faz a requisição utilizando o axios e usando promise:
        //axios.get(`"http://localhost:8080/sales")
        // Variável configurada dentro de utils > request.ts
        axios.get(`${BASE_URL}/sales/byDate?minDate=2021-11-01&maxDate=2021-12-31`) // Usar esse endpoint por enquanto porque está paginado e tem o content.
            .then(response => {
                console.log(response.data);
                setSales(response.data.content);
            });
    }, []);

    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={minDate} // Valor que fica dentro do DatePicker
                        onChange={(novaData: Date) => setMinDate(novaData)} // Ao selecionar a novaData no DatePicker, ela irá atualizar o componente
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={maxDate} // Valor que fica dentro do DatePicker
                        onChange={(novaData: Date) => setMaxDate(novaData)} // Ao selecionar a novaData no DatePicker, ela irá atualizar o componente
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            sales.map(sale => { // .map percorre a lista e faz uma operação para cada elemento da mesma.
                                // tr key{sale.id}: Quando fazemos qualquer renderização no React, baseado em uma lista, precisamos definir a chave da mesma em cada elemento.
                                // .toFixed(2): Formata o numero para ter duas casas decimais.
                                // .toLocaleDateString(): Formata a data para formato Local.
                                return (
                                    <tr key={sale.id}>
                                        <td className="show992">{sale.id}</td>
                                        <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                        <td>{sale.sellerName}</td>
                                        <td className="show992">{sale.visited}</td>
                                        <td className="show992">{sale.deals}</td>
                                        <td>R${sale.amount.toFixed(2)}</td>
                                        <td>
                                            <div className="dsmeta-red-btn-container">
                                                <NotificationButton />
                                            </div>
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default SalesCard;