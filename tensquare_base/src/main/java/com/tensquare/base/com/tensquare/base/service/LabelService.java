package com.tensquare.base.com.tensquare.base.service;

import com.tensquare.base.com.tensquare.base.dao.LabelDao;
import com.tensquare.base.com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tensquare_parent
 * @description: 标签业务类
 * @author: Linweizhe
 * @create: 2018-12-05 20:40
 **/
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    IdWorker idWorker;

    public List<Label> getAll() {
        return labelDao.findAll();
    }

    public Label findLabelById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void delete(String id) {
        labelDao.deleteById(id);
    }

    public List<Label> search(Label label) {
        List<Predicate> list = new ArrayList();
        // 通过实现Specification接口 来实现条件查询
        List<Label> labels = labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //相当于 where labelname =%{ }%
                if (null != label.getLabelname() && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (null != label.getState() && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        });
        return labels;
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        List<Predicate> list = new ArrayList();
        Pageable pageable = new PageRequest(page - 1, size);
        Page<Label> pageData = labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //相当于 where labelname =%{ }%
                if (null != label.getLabelname() && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (null != label.getState() && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        }, pageable);

        return pageData;
    }
}
