databaseChangeLog() {
    changeSet(id: '1', author: 'Nodir') {
        sqlFile(path: 'changesets/Init.sql')
    }
}

//databaseChangeLog() {
//    changeSet(id: 'create schema service_manager', author: 'Abduvohid') {
//        sql("call public.create_schema('service_manager','${DB_SERVICE_USER}'); ")
//    }
//
//    changeSet(id: 'create db extension', author: 'Abduvohid') {
//        sqlFile(path: 'changesets/EXTENSION1_0__create_extension.sql')
//    }
//
//    include(file: "changesets/service/service.groovy", relativeToChangelogFile: true)
//    include(file: "changesets/condition/condition.groovy", relativeToChangelogFile: true)
//}