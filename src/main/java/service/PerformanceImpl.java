package service;

import org.springframework.stereotype.Service;

@Service
public class PerformanceImpl implements Performance {
    public void perform(){
        System.out.println("paly");
    }

    @Override
    public void perform(int i) {
        System.out.println("paly"+i);
    }

    public void shutdown(){
        System.out.println("shutdown");
    }
}
