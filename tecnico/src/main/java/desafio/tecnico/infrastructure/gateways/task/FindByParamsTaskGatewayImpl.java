package desafio.tecnico.infrastructure.gateways.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import desafio.tecnico.application.gateways.task.FindByParamsTaskGateway;
import desafio.tecnico.domain.TaskParams;
import desafio.tecnico.domain.entities.Task;
import desafio.tecnico.infrastructure.mapper.TaskEntityMapper;
import desafio.tecnico.infrastructure.persistence.entities.TaskEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class FindByParamsTaskGatewayImpl implements FindByParamsTaskGateway {

    @PersistenceContext
    private EntityManager entityManager;
    private final TaskEntityMapper mapper;

    public FindByParamsTaskGatewayImpl(TaskEntityMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<Task> execute(TaskParams params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TaskEntity> query =  builder.createQuery(TaskEntity.class);
        Root<TaskEntity> from = query.from(TaskEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (params.getStatus() != null) {
            predicates.add(builder.equal(from.get("status"), params.getStatus()));
        }

        if (params.getPriority() != null) {
            predicates.add(builder.equal(from.get("priority"), params.getPriority()));
        }

        query.where(predicates.stream().toArray(Predicate[]::new));
        List<TaskEntity> result = entityManager.createQuery(query).getResultList();
        return result.stream()
            .map(mapper::toDomain)
            .toList();
    }
    
}
