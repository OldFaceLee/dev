package com.ai.dev.dao.impl;

import com.ai.dev.common.pageHelper.PageInfo;
import com.ai.dev.dao.ITpTestcaseDao;
import com.ai.dev.em.TestcaseEnum;
import com.ai.dev.mapper.customized.TpTestcaseRequest;
import com.ai.dev.mapper.interfaces.TpTestcaseMapper;
import com.ai.dev.mapper.vo.TpTestcase;
import com.ai.dev.mapper.vo.TpTestcaseCriteria;
import com.github.pagehelper.PageHelper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午6:04
 * @description:
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TpTestcaseDaoImpl implements ITpTestcaseDao {

    @Autowired
    TpTestcaseMapper mapper;

    @Override
    public int insert(TpTestcase testcase) {
        return mapper.insert(testcase);
    }

    @Override
    public int update(TpTestcase testcase) {
        return mapper.updateByPrimaryKeySelective(testcase);
    }

    @Override
    public List<TpTestcase> select(String caseId) {
        if(StringUtils.isEmpty(caseId)){
            return Collections.emptyList();
        }
        TpTestcaseCriteria sql = new TpTestcaseCriteria();
        sql.or().andCaseIdEqualTo(caseId).andIsValidEqualTo(TestcaseEnum.VALID.getValue());
        List<TpTestcase> caseInfo = mapper.selectByExample(sql);
        return Optional.ofNullable(caseInfo).orElse(Collections.emptyList());
    }

    @Override
    public PageInfo<TpTestcase> queryForPageInfo(TpTestcaseRequest tpTestcaseRequest) {
        TpTestcaseCriteria sql = new TpTestcaseCriteria();
        TpTestcaseCriteria.Criteria criteria = sql.or();
       /* if(tpTestcaseRequest.getIsValid() == TestcaseEnum.VALID.getValue()){
            criteria.andIsValidEqualTo(TestcaseEnum.VALID.getValue());
        }
        if(tpTestcaseRequest.getIsValid() == TestcaseEnum.INVALID.getValue()){
            criteria.andIsValidEqualTo(TestcaseEnum.INVALID.getValue());
        }*/
        if(tpTestcaseRequest.getCaseDesc() != null){
            criteria.andCaseDescEqualTo(tpTestcaseRequest.getCaseDesc());
        }
        if(tpTestcaseRequest.getCaseGroups() != null){
            criteria.andCaseGroupsEqualTo(tpTestcaseRequest.getCaseGroups());
        }
        if(tpTestcaseRequest.getCaseId() != null){
            criteria.andCaseIdEqualTo(tpTestcaseRequest.getCaseId());
        }
        if(tpTestcaseRequest.getCaseName() != null){
            criteria.andCaseNameEqualTo(tpTestcaseRequest.getCaseName());
        }
        sql.setOrderByClause("create_date DESC");
        return new PageInfo<>(PageHelper.startPage(tpTestcaseRequest.getPageNo(), tpTestcaseRequest.getPageSize()).doSelectPageInfo(() -> mapper.selectByExample(sql)));
    }
}
