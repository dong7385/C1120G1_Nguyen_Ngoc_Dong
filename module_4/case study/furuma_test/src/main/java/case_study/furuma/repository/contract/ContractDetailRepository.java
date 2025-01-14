package case_study.furuma.repository.contract;

import case_study.furuma.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    Page<ContractDetail> findAll(Pageable pageable);

}

