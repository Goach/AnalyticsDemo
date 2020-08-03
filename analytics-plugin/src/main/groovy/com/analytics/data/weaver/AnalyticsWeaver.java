package com.analytics.data.weaver;

import com.analytics.data.visitor.AnalyticsVisitor;
import com.quinn.hunter.transform.asm.BaseWeaver;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 * author: Goach.zhong
 * Date: 2020-08-03 13:57
 * Des:
 **/
public class AnalyticsWeaver extends BaseWeaver {
    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new AnalyticsVisitor(classWriter);
    }
}
