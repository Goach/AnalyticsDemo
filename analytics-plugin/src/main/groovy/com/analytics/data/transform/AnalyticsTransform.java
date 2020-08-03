package com.analytics.data.transform;

import com.analytics.data.weaver.AnalyticsWeaver;
import com.quinn.hunter.transform.HunterTransform;

import org.gradle.api.Project;

/**
 * author: Goach.zhong
 * Date: 2020-08-03 11:15
 * Des:
 **/
public class AnalyticsTransform extends HunterTransform {
    public AnalyticsTransform(Project project) {
        super(project);
        bytecodeWeaver = new AnalyticsWeaver();
    }
}
