package com.example.demo;

import lombok.*;
import org.hibernate.envers.*;
import org.hibernate.envers.query.*;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final EntityRepository repository;
    private final EntityManager em;

    @GetMapping("{id}")
    public Entity getIssues(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("{id}")
    public Entity getIssues(@RequestBody Entity entity) {
        return repository.save(entity);
    }

    @GetMapping("history/{id}")
    public Map<String, String> getHistoryById(@PathVariable long id) {
        List<Object []> resultList = AuditReaderFactory.get(em).createQuery()
                .forRevisionsOfEntity(Entity.class, false, true)
                .add(AuditEntity.id().eq(id))
                .getResultList();
        Map<String, String> map = new HashMap<>();
        resultList.stream().map(item -> {
            map.put("Name", item[0].toString());
            map.put("Date", item[1].toString());
            map.put("Revision type", item[2].toString());
            return map;
        }).toList();
        return map;
    }
}
