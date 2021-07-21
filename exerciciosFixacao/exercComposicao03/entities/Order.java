package cursoUdemyNelio.exerciciosFixacao.exercComposicao03.entities;

import cursoUdemyNelio.exerciciosFixacao.exercComposicao03.enums.OrderStatus;

import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    SimpleDateFormat sdfBirth = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    List<OrderItem> orderItems = new ArrayList<>();
    Client client = new Client();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = Date.from(Instant.now());
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Double total() {
        Double totalValue = 0.0;
        for (OrderItem o : orderItems) {
            totalValue += o.subTotal();
        }

        return totalValue;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("ORDER SUMARY: ").append("\n")
                .append("Order moment: " + sdfOrder.format(moment)).append("\n")
                .append("Order Status: " + status).append("\n")
                .append("Client: " + client.getName()).append(" (").append(sdfBirth.format(client.getBirthDate()))
                .append(")").append(" - ").append(client.getEmail()).append("\n")
                .append("Order Items:").append("\n");

        for (OrderItem item : orderItems) {

            str.append(item + "\n");
        }
        str.append("Total price: $");
        str.append(String.format("%.2f", total()));

        return str.toString();
    }


}
