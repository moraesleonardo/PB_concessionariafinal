package info.moraes.pb_concessionaria.service;
import info.moraes.pb_concessionaria.exception.ResourceNotFoundException;
import info.moraes.pb_concessionaria.model.Carro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class CarroService {


    List<Carro> carros = initValues();

    private List<Carro> initValues() {
        ArrayList<Carro> carros1 = new ArrayList<>();
        carros1.add(new Carro(0, "Ranger", "Pick-up"));
        carros1.add(new Carro(1, "Santana", "Sedan"));
        carros1.add(new Carro(2, "Polo", "Hatch"));
        return carros1;
    }

    public Carro getById(int id) {
        if (id < 0) {
            throw new ResourceNotFoundException("Valor Inválido - Não pode ser negativo");
        }else {
            Optional<Carro> carroOpt = carros.stream().filter(carro -> carro.getCodigo() == id).findFirst();
            if(carroOpt.isEmpty()) throw new ResourceNotFoundException("Objeto não encontrado");
            return carroOpt.get();

        }
    }

    public void save(Carro carro){
        carros.add(carro);
    }
    public List<Carro> getAll(){
        return this.carros;
    }
    public List<Carro> filterByName(String nome) {
        List<Carro> all = getAll();
        List<Carro> resultado = all.stream().filter(carro -> carro.getNome().startsWith(nome)).toList();

        return resultado;
    }
    public void deleteById(Integer id) {
        if (resourceNotFound(id)) {
            throw new ResourceNotFoundException("Carro não localizado");
        }
        carros.remove(carros.get(id));
    }
    public void update(Integer id, Carro carro){
        if (resourceNotFound(id)) {
            throw new ResourceNotFoundException("Carro não localizado");
        }
        carros.set(id, carro);
    }

    private boolean resourceNotFound(Integer id){
        return carros.stream().filter(carro -> carro.getCodigo() == id).findFirst().isEmpty();
    }


}
