package com.analytics.data;

import com.analytics.data.transform.AnalyticsTransform;
import com.android.build.gradle.AppExtension;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import java.util.Collections;
import java.util.List;

public class AnalyticsDataPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        List<String> taskNames = project.getGradle().getStartParameter().getTaskNames();
        //如果是Release版本，则不进行字节码替换
        for(String taskName : taskNames){
            if(taskName.contains("Release")){
                return;
            }
        }
        //创建自定义扩展
        project.getExtensions().create("analyticsExtension", AnalyticsExtension.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                AnalyticsExtension extension = project.getExtensions().getByType(AnalyticsExtension.class);
                PluginConst.pluginEnable = extension.pluginEnable;
                PluginConst.logEnable = extension.logEnable;
            }
        });
        AppExtension appExtension = (AppExtension) project.getProperties().get("android");
        appExtension.registerTransform(new AnalyticsTransform(project), Collections.EMPTY_LIST);
    }
}
