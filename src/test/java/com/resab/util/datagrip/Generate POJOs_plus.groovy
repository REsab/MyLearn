package com.resab.util.datagrip

import com.intellij.database.model.DasTable
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

/*
复制到datagrip extention目录 schema

 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */

packageName = "com.zdt.otc.data.job.core.entity;"
typeMapping = [(~/(?i)int/)                      : "Long",
               (~/(?i)float|double|decimal|real/): "Double",
               (~/(?i)datetime|timestamp/)       : "java.sql.Timestamp",
               (~/(?i)date/)                     : "java.sql.Date",
               (~/(?i)time/)                     : "java.sql.Time",
               (~/(?i)/)                         : "String"]

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir -> SELECTION.filter { it instanceof DasTable }.each { generate(it, dir) }
}

def generate(table, dir) {
    System.out.println("Hello World");
    println "Hello World"

    def className = javaName(table.getName(), true)
    def fields = calcFields(table)
    new File(dir, className + ".java").withPrintWriter { out -> generate(out, className, fields, table.getName()) }
}

def generate(out, className, fields, tableName) {
    out.println "package $packageName"
    out.println ""
    out.println ""
    out.println "@Data"
    out.println "@ApiModel"
    out.println "@TableName( \"$tableName\")"
    out.println "public class $className {"
    out.println ""
    fields.each() {
        if (it.annos != "") out.println "  ${it.annos}"
        out.println "    @ApiModelProperty(value = \" ${it.comment}\")"
        out.println "    private ${it.type} ${it.name};"
        out.println ""
    }
    out.println ""
//   fields.each() {
//     out.println ""
//     out.println "  public ${it.type} get${it.name.capitalize()}() {"
//     out.println "    return ${it.name};"
//     out.println "  }"
//     out.println ""
//     out.println "  public void set${it.name.capitalize()}(${it.type} ${it.name}) {"
//     out.println "    this.${it.name} = ${it.name};"
//     out.println "  }"
//     out.println ""
//   }
    out.println "}"
}

def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def spec = Case.LOWER.apply(col.getDataType().getSpecification())
        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value

        println "Hello World11"

        println "col: ${col.getName()}"
        println "col: ${col.getDataType().getSpecification()}"
        println "col: ${col}"
        println "colasdkflsaj : ${col.comment}"

        fields += [[name   : javaName(col.getName(), false),
                    type   : typeStr,
                    comment: col.comment,
                    annos  : ""]]
    }
}

def javaName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}
