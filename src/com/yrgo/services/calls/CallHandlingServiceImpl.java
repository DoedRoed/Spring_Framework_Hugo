package com.yrgo.services.calls;

import com.yrgo.domain.Action;
import com.yrgo.domain.Call;
import com.yrgo.services.customers.CustomerManagementService;
import com.yrgo.services.customers.CustomerNotFoundException;
import com.yrgo.services.diary.DiaryManagementService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

public class CallHandlingServiceImpl implements CallHandlingService{
    @Override
    public void recordCall(String customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {
        ClassPathXmlApplicationContext cointainer = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService customerManagementService = cointainer.getBean(CustomerManagementService.class);
        DiaryManagementService diaryManagementService = cointainer.getBean(DiaryManagementService.class);

         customerManagementService.recordCall(customerId, newCall);

         actions.forEach(diaryManagementService::recordAction);
    }
}
