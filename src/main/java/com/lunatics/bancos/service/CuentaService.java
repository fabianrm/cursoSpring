package com.lunatics.bancos.service;

import com.lunatics.bancos.exception.CuentaNotFoundException;
import com.lunatics.bancos.model.Cuenta;
import com.lunatics.bancos.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listAll() {
        return cuentaRepository.findAll();
    }

    public Cuenta get(Integer id) {
        return cuentaRepository.findById(id).get();
    }

    public Cuenta save(Cuenta c) {
        return cuentaRepository.save(c);
    }

    public void delete(int id) throws CuentaNotFoundException {
        if (!cuentaRepository.existsById(id)){
            throw new CuentaNotFoundException("Cuenta no encontrada con el ID " + id);
        }
        cuentaRepository.deleteById(id);
    }

    //Depositar dinero
    public Cuenta depositar(float monto, Integer id){
        cuentaRepository.actualizarMonto(monto, id);
        return cuentaRepository.findById(id).get();
    }

    //Retirar dinero
    public Cuenta retirar(float monto, Integer id){
        cuentaRepository.actualizarMonto(-monto, id);
        return cuentaRepository.findById(id).get();
    }

}
