Ext.define('CPRS.store.Reviewers' ,{
    extend: 'Ext.data.Store',
    model: 'CPRS.model.Reviewer',
    autoLoad: true
    
//,
//    listeners: {
//        load: this.onLoad,
//        scope: this
//    },


    /*
	data: [
            {id:1, 
            	reviewer: 'Ruma Banerjee',    
            	phone: '1112223456',
            	email: 'RBanerjee@abc.com',
            	affschools: [
            	   {
            		   value: '1'
            	   },
            	   {
            		   value: '2'
            	   },
            	   {
            		   value: '3'
            	   }
            	]
            },
            {id:2, 
            	reviewer: 'Robert A Copeland',    
            	phone: '1112223456',
            	email: 'Copeland@abc.com',
            	affschools: [
                      	   {
                      		   value: '1'
                      	   },
                      	   {
                      		   value: '2'
                      	   },
                      	   {
                      		   value: '3'
                      	   }
                      	]
            },
            {id:3, 
            	reviewer: 'Ron W Darbeau',    
            	phone: '1112223456',
            	email: 'Darbeau@abc.com',
            	affschools: [
                      	   {
                      		   value: '1'
                      	   },
                      	   {
                      		   value: '2'
                      	   },
                      	   {
                      		   value: '3'
                      	   }
                      	]
            },
            {id:4, 
            	reviewer: 'Ron C Estler',    
            	phone: '1112223456',
            	email: 'Estler@abc.com',
            	affschools: [
                      	   {
                      		   value: '1'
                      	   },
                      	   {
                      		   value: '2'
                      	   },
                      	   {
                      		   value: '3'
                      	   }
                      	]
            },
            {id:5, 
            	reviewer: 'Joseph S Francisco',    
            	phone: '1112223456',
            	email: 'Francisco@abc.com',
            	affschools: [
                      	   {
                      		   value: '1'
                      	   },
                      	   {
                      		   value: '2'
                      	   },
                      	   {
                      		   value: '3'
                      	   }
                      	]
            },
            {id:6, 
            	reviewer: 'Cornelia D Gilyard',    
            	phone: '1112223456',
            	email: 'Gilyard@abc.com',
            	affschools: [
                      	   {
                      		   value: '3'
                      	   },
                      	   {
                      		   value: '4'
                      	   },
                      	   {
                      		   value: '5'
                      	   }
                      	]
            }
	]    
*/
//    load( Ext.data.Store this, Ext.util.Grouper[] records, Boolean successful, Ext.data.Operation operation, Object eOpts )
/*    
onLoad: function() {
	console.log('Reviewers onload()');
        //the reviewer that was loaded
        var reviewer = store.first();

        console.log("Orders for " + reviewer.get('reviewer') + ":")

        //iterate over the Orders for each User
        reviewer.orders().each(function(order) {
            console.log("Order ID: " + order.getId() + ", which contains items:");

            //iterate over the OrderItems for each Order
            order.orderItems().each(function(orderItem) {
                //we know that the Product data is already loaded, so we can use the synchronous getProduct
                //usually, we would use the asynchronous version (see Ext.data.BelongsToAssociation)
                var product = orderItem.getProduct();

                console.log(orderItem.get('quantity') + ' orders of ' + product.get('name'));
            });
        });
    }
*/

});
