import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import NotificationButton from '../NotificationButton';

import "react-datepicker/dist/react-datepicker.css";
import './styles.css';
import axios from "axios";

function SalesCard() {

    // Função pra pegar a data de 1 ano atrás:
    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date(); // Data de hoje.

    // Declaração de dado composto, onde temos o dado (minDate) e a função que muda o dado (setMinDate) que usaremos para alterar o dado:
    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    // useEffect: Serve para executar algo qnd o componente é montado ou quando o dado alterar.
    // Uma função como primeiro argumento e uma lista no segundo.
    useEffect(() => {
        console.log("TESTE: ");
        // Faz a requisição utilizando o axios e usando promise:
        axios.get("http://localhost:8080/sales")
            .then(response => {
                console.log(response.data);
            })
    }, [])

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
                        <tr>
                            <td className="show992">#123</td>
                            <td className="show576">08/07/2022</td>
                            <td>Din Djarin</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 12345.67</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="show992">#124</td>
                            <td className="show576">08/07/2022</td>
                            <td>Luke Skywalker</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 987654.32</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="show992">#125</td>
                            <td className="show576">08/07/2022</td>
                            <td>Moff Gideon</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 15948.26</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>

        </div>
    )
}

export default SalesCard;