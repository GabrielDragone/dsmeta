// Importa o icone e armazena dentro de icon, para posteriormente inserimos dentro de img src dentro de chaves {icon}:
// Pasta anterior é ../:
import axios from 'axios';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';

// ./ Pq está na mesma pasta do componente:
import './styles.css';

// Esse tipo Props pode ter um ou mais atributos e ele será utilizado para ser enviado ao Componente:
type Props = {
    saleId: number,
}

// Função de enviar notificação de dentro do NotificationButton propriedade onClick():
function enviarNotificacao(id: number) {
    axios(`${BASE_URL}/sales/${id}/notifySms`)
        .then(respone => {
            alert("Notificação enviada!");
        });
}

// No React não utilizaremos a class (pq é do js) e sim className:
function NotificationButton({ saleId }: Props) { // Assim que passamos o Parâmetro para o componente que será utilizado dentro do onClick(). Verificar como é chamado no SalesCard.
    return (
        <div className="dsmeta-red-btn" onClick={() => enviarNotificacao(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton;


