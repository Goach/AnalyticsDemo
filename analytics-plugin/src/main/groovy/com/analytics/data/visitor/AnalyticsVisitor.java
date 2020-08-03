package com.analytics.data.visitor;

import com.analytics.data.PluginConst;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * author: Goach.zhong
 * Date: 2020-08-03 13:59
 * Des:
 **/
public class AnalyticsVisitor extends ClassVisitor {
    private String className;
    public AnalyticsVisitor(ClassVisitor classWriter) {
        super(Opcodes.ASM5, classWriter);
    }
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.className = name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String methodName, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, methodName, desc, signature, exceptions);
        if(!PluginConst.pluginEnable) {
            return mv;
        }
        return super.visitMethod(access, methodName, desc, signature, exceptions);
    }
}
