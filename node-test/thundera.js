console.log('Testing Thundera Event Listener Module');

var Thundera = require('../release/thundera-event-listener');

var data = {
            id: "channel_id",
            attendant: "diego",
            status: "waiting",
            channelCreatedAt: "a date"
        };

Thundera.registerEvent('CHANNEL_STATUS_CHANGE', data);