// Importa o icone e armazena dentro de icon, para posteriormente inserimos dentro de img src dentro de chaves {icon}:
// Pasta anterior é ../:
import icon from '../../assets/img/notification-icon.svg'

// ./ Pq está na mesma pasta do componente:
import './styles.css'

// No React não utilizaremos a class (pq é do js) e sim className:
function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton;
