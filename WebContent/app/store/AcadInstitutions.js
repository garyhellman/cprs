Ext.define('CPRS.store.AcadInstitutions', {
    extend: 'Ext.data.Store',
    model: 'CPRS.model.AcadInstitution',
    autoLoad: true,
    pageSize: 35,
    autoLoad: {start: 0, limit: 35},
    
    proxy: {
        type: 'ajax',
        api: {
        	read : 'acadinstitution/view.action',
            create : 'acadinstitution/create.action',
            update: 'acadinstitution/update.action',
            destroy: 'acadinstitution/delete.action'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            root: 'data'
        },
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'REMOTE EXCEPTION',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    }
});