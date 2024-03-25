package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.MaintenanceMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ManitenanceBusinessRules {
    private MaintenanceRepository maintenanceRepository;
    public void idIsNotExists (int id){
        Optional<Maintenance> maintenance=this.maintenanceRepository.findById(id);
        if(maintenance.isEmpty()){
            throw new BusinessException(MaintenanceMessages.idIsNotExists);
        }
    }

}
