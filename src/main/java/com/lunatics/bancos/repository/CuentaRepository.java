package com.lunatics.bancos.repository;

import com.lunatics.bancos.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("UPDATE Cuenta c SET c.monto=c.monto + ?1 WHERE c.id=?2")
    @Modifying
    void actualizarMonto(float monto, Integer id);

}
