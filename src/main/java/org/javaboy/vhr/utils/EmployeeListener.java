package org.javaboy.vhr.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.javaboy.vhr.mapper.EmpBasicMapper;
import org.javaboy.vhr.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: TongYaZhou
 * @create: 2020-07-22 14:45
 **/
public class EmployeeListener extends AnalysisEventListener<Employee> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(org.javaboy.vhr.utils.EmployeeListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<Employee> list = new ArrayList<Employee>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private EmpBasicMapper empBasicMapper;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     */
    public EmployeeListener(EmpBasicMapper empBasicMapper) {
        this.empBasicMapper = empBasicMapper;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param context
     */
    @Override
    public void invoke(Employee employee, AnalysisContext context) {
        try {
            LOGGER.info("解析到一条数据:{}", new ObjectMapper().writeValueAsString(employee));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        list.add(employee);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        for (Employee employee : list) {
            empBasicMapper.addEmployee(employee);
        }
        LOGGER.info("存储数据库成功！");
    }
}
