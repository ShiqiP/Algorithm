/**
 * @param {string} queryIP
 * @return {string}
 */
var validIPAddress = function (queryIP) {
    // 1. four numbers/chars split by .
    // 2. determine its IPV4 OR IPV6
    // regex



    if (queryIP.includes('.')) {
        return checkIPv4(queryIP.split('.')) ? "IPv4" : "Neither";
    } else if (queryIP.includes(':')) {
        return checkIPv6(queryIP.split(':')) ? "IPv6" : "Neither";
    } else {
        return "Neither"
    }

    function checkIPv4(arr) {
        return arr.length == 4 && arr.every(x =>
            (x <= 255 && x >= 0) &&
            Number(x).toString() === String(x)
        )
    }

    function checkIPv6(arr) {
        const map = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'];
        return arr.length == 8 && arr.every(x =>
            (x.length > 0 && x.length <= 4) && (x.split('').every(n => map.includes(n)))
        )
    }

    function isNumeric(val) {
        return !isNaN(parseFloat(val)) && isFinite(val);
    }
};