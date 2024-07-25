databaseChangeLog() {
    changeSet(id: '1', author: 'Nodir') {
        sqlFile(path: 'changesets/Init.sql')
    }
    changeSet(id: '2.create_cards_table', author: 'Nodir') {
        sqlFile(path: 'changesets/create_cards_table.sql')
    }
}