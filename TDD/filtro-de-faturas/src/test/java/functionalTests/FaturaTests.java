package functionalTests;

import br.com.ufcg.vv.tdd.filtro.fatura.Cliente;
import br.com.ufcg.vv.tdd.filtro.fatura.Fatura;
import br.com.ufcg.vv.tdd.filtro.fatura.FiltroFaturas;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FaturaTests {

    @Test
    public void teste01() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "01/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("001", 1999.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste02() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "RJ");
        Fatura fatura = new Fatura("002", 2000.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste03() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("003", 2001.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste04() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "07/04/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "RS");
        Fatura fatura = new Fatura("004", 2499.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste05() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/04/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "PR");
        Fatura fatura = new Fatura("005", 2500.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste06() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "15/03/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("006", 2501.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste07() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "09/03/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("Maria", data, "PB");
        Fatura fatura = new Fatura("007", 2999.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste08() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("Pedro", data, "SP");
        Fatura fatura = new Fatura("008", 3000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste09() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("Ana", data, "PB");
        Fatura fatura = new Fatura("009", 4000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste10() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("Julia", data, "RS");
        Fatura fatura = new Fatura("010", 4001.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    //  Partições por Equivalência Forte


    @Test
    public void teste11() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("001", 1000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste12() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "RS");
        Fatura fatura = new Fatura("001", 2000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste13() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "29/04/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("001", 2200.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste14() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "RS");
        Fatura fatura = new Fatura("001", 2499.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste15() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "PR");
        Fatura fatura = new Fatura("001", 2500.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste16() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SC");
        Fatura fatura = new Fatura("001", 2600.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste17() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "RS");
        Fatura fatura = new Fatura("001", 3000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste18() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("001", 4000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
    }

    @Test
    public void teste19() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "PR");
        Fatura fatura = new Fatura("001", 5000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste20() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "RS");
        Fatura fatura = new Fatura("001", 6000.0, LocalDate.now(), cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    public void teste21() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = "08/05/2023";
        LocalDate data = LocalDate.parse(dataString, formatter);

        Cliente cliente = new Cliente("João", data, "SP");
        Fatura fatura = new Fatura("001", 1000.0, data, cliente);
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }



}
