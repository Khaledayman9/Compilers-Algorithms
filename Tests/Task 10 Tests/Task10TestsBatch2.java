package csen1002.tests.task10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task10.Task10Lexer;
import csen1002.main.task10.Task10Parser;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task10TestsBatch2 {
	
	/**
     * Parses a provided string using Task 10's grammar
     * and gets the value of the attribute "val" of the variable "s"
     *
     * @param input a string to parse
     * @return the value of the attribute "val" of the variable "s"
     */
    public static int sValValue(String input) {
        Task10Lexer lexer = new Task10Lexer(CharStreams.fromString(input));
        Task10Parser parser = new Task10Parser(new CommonTokenStream(lexer));
        return parser.s().val;
    }


	@Test
	public void testString1() {
		assertEquals(14, 
        sValValue("1311,4949,3171,1810,8621,1440,1440,8259,8838,9529,8381,8381,8381,1956,6940,7007,2005,4012,3517,3140,9815,9815,9815,2727,9329,5217,5217,5217,5217,7032,7169,6547,2011,8706,8704,3566,1601,3271,8364,8364,9312,9520,8586,6951,6992,3288,448,448,7191,7191,6176,3950,9984,1556,1556,1556,1081,8217,5722,5146,8657,8657,7470,7470,7470,2664,1850,1352,893,2468,752,5711,2632,4107,8157,9941,9941,9941,217,2795,1042,6983,7973,642,1793,8912,507,507,5755,8411,8411,6442,656,4300,8435,6780,6780,2833,801"));
	}

	@Test
	public void testString2() {
		assertEquals(8, 
        sValValue("5139,5139,5139,5139,6770,8283,4572,8772,8820,5856,2985,1885,222,222,222,9409,7917,5864,8591,566,9300,5885,8249,8913,2566,320,773,848,5867,3102,8742,9605,812,2395,5112,4735,4635,8047,5774,2317,9032,2466,1956,7247,4033,7929,6108,7350,8986,3095,6298,2696,4349,1599,8383,2552,7342,5976,4471,9,9,9,2265,1489,1489,6663,1713,917,8395,7184,6884,843,3341,2544,4571,8155,8736,4731,1600,140,6191,7056,6088,4503,1886,4376,4376,4376,341,412,5741,8432,1630,8492,7197,8371,3296,3296,1030,6742,6496,3190,9104,7808,5312,4073,9335,3660,7909,5824,7630,9973,6768,3311,3576,7585,6838,7730,635,6202,1808,1579,6778,386,31,3743,7935,8728,2814,8884,5950,7678,313,2555,4317,6061,6284,7807,8061,8710,2800,659,1484,7889,690,4677,8240,412,7077,1569,1479,8917,4836,7713,1649,7929,1646,69,5314,8677,6239,2747,4266,1160,9552,2568,9082,1388,7329,6770,8006,2819,1184,1184,1184,1184,4651,9151,297,8419,547,9866,6345,5473,7866,3716,5925,8451,2593,571,5373,3881,5133,5358,4299,8676,8676,8676,8676,2576,9807,6592,2514,8779,7748,1816,8237,2862,2743,5535,9385,4045,9141,210,766,2269,5919,3719,1320,3848,1210,7313,7222,3801,7166,6567,8617,8877,5909,4052,21,9213,3482,6549,7035,3253,227,1507,4891,157,2812,7143,7585"));
	}

	@Test
	public void testString3() {
		assertEquals(23, 
        sValValue("7177,835,9207,4818,4818,8126,5065,6994,406,7138,7138,7138,7005,7005,6368,1399,5330,993,2443,4076,807,209,209,8837,6916,1815,8534,819,8002,1203,1203,1203,1203,9532,9532,9532,1448,6514,5474,4850,8966,9372,9372,9638,1688,701,701,6952,6952,7054,8428,6817,6538,1665,4457,6251,2360,8154,8154,9250,4590,9720,5507,397,397,2319,2319,2319,2319,1050,9992,9992,9992,8996,1082,5914,7515,7515,5838,8195,8195,8195,168,8822,4360,9668,32,9008,9008,8649,4850,8046,5757,7230,7230,7230,7230,5896,9965,320,3990,5958,8827,7563,3969,6490,1,4892,4892,4892,4892,9183,9109,6785,549,549,549,1005,1326,3979,3208,8478,6120,6120,2238,2238,2238,5600,897,897,897,897,4340,7677,9365,4041,1825,3729,8692,716,3154,1430,8585,5375,4883,6238,9951,5477,6137,6103,6103,6860,391,5850,9267,5523,9402"));
	}

	@Test
	public void testString4() {
		assertEquals(5, 
        sValValue("7441,4984,263,7350,2328,1931,3270,6148,3789,3778,4624,4624,4624,7498,42,4618,1711,693,6781,440,7630,7337,2425,9712,2590,9396,4832,5943,3030,3030,3030,7929,8563,659,6378,3994,980,9193,1181,2716,9094,7981,7229,4568,4297,4531,1041,7462,8315,5609,6058,4990,920,653,551,4082,6472,8620,3724,7651,2061,8270,9278,6047,5532,277,7629,2291,2605,5878,267,9940,8425,781,2325,9186,417,4997,2323,6311,6093,8918,1285,4006,1604,3481,6912,5181,4243,7596,2385,931,4867,9133,3475,4046,4231,6720,2127,3128,642,8354,9452,8730,3732,3732,3732,4983,9413,6149,2202,3164,7039,3787,9953,5378,34,6062,701,6135,3469,5225,935,8992,4981,5144,4303,5152,5399,9173,3929,5626,9763,7938,2765,2570,6093,9415,5995,6539,8295,1295,1246,2946,6515,3490,8310,8310,8310,6892,2777,2920,6893,6102,9749,3414,2989,4431,8545,6111,7776,1759,6477,5519,2595,5140,4001,7345,3948,7760,7872,2583,4124,594,4415,1120,4576,7589,9372,4491,4380,2258,5093,4589,6810,3377,5479,169,8100,207,3975,6588,6588,6588,6588,5794,3800,3086,202,8506,9782,3555,6337,5965,6910,9282,5240,6034,680,2959,8500,1884,9695,1081,4070,8577,9771,8047"));
	}

	@Test
	public void testString5() {
		assertEquals(23, 
        sValValue("7869,6526,6526,6526,6526,8424,6957,4820,4547,4547,4547,5792,3558,718,2009,2009,2009,2009,5955,3435,3714,57,5608,7035,7505,7505,754,8660,1166,9653,2931,6902,4057,8384,8384,8384,8979,9994,8142,8142,8142,8142,8276,8512,3529,1453,5488,5760,3565,2786,9507,5791,7404,6377,4927,8242,1678,1678,8738,1638,6012,6012,6012,6012,8246,2826,7,1499,3423,6085,6085,6085,6085,8534,1213,1785,3043,1017,1017,8092,4258,3969,5214,4204,4204,6608,6608,9950,9147,2117,9910,4903,4155,7549,2178,2178,2178,2178,1342,6606,5240,3692,6870,1087,1549,5696,7474,3837,3227,4439,3467,7950,9055,9055,9055,9055,3184,6570,6175,7370,4131,2535,6409,1968,3770,9855,9928,9983,9983,9983,8201,8201,8201,8201,2956,4551,9103,8523,6951,3986,5039,6449,9747,6498,8174,3207,6249,8396,7972,2673,5377,1374,5675,5675,9769,4957,2138,5413,7795,9816,3628,518,518,518,1388,341,2013,2013,2013,5866,4578,5393,5987,3570,7190,3578,2514,8600,3868,5494,8172,8412,8412,7617,2804,2437,4973,9648,7201,1436,4199,9183,6846,972,8270,9992,661,5101,3874,1611,106,6068,9320,6895,351,9659,2471,8118,8035,7673,4640,7375,9435,732,4079,9099,7902,9602,8691,7620,1986,5645,7665,709,8679,929,929,929,929,131,3981,69,2908,4570,6060,4089,4089,5332,4524,8991,8541,8321,3119,2603,2180,2180,2180,425,4225,7190,2025"));
	}

	@Test
	public void testString6() {
		assertEquals(5, 
        sValValue("7217,2872,7008,5969,5969,5969,4680,6603,5540,5540,9553,8145,723,6158,1587,6041,6041,6041,6041,2740,7602,3425,3730,6900,5219,1029,8052,558,4193,909,6032,6448,7197,8306,1296,1613,1613,1613,1613,5313,1956,7056,5058,3799,3799,3799,2671,9819,2128,2648,3494,1889,6167,1594,7170,795"));
	}

	@Test
	public void testString7() {
		assertEquals(1, 
        sValValue("8932,1662,2803,1011,5147,3349,3349,3349,9362,3945,9876,8184,7164,7499,6368,7877,2648,4838,3679,770,9706,9225,5659,2203,9824,771,9994"));
	}

	@Test
	public void testString8() {
		assertEquals(3, 
        sValValue("146,5850,8432,5993,5601,6554,9050,5077,1835,6821,9317,3117,4146,9624,4702,9541,8217,6460,937,7596,295,5856,7446,2426,7030,5816,6729,7841,4236,7542,8585,5184,6294,6314,8234,189,8306,4207,381,1431,1172,8515,7054,5337,5337,5337,5337,7046,5778,9189,5637,4753,6178,8385,4969,3902,3289,5302,1562,7267,9945,9877,5075,4600,5392,9652,2014,9589,2302,5103,9284,6794,2202,115,4728,5376,5860,5884,47,1995,3610,8535,2621,6113,6854,2982,6650,7136,6060,8178,784,4301,2459,1780,8924,7051,333,5471,3260,5715,4305,5721,3743,9800,1354,8581,6210,3888,427,1283,2130,9236,3460,7859,6565,2502,362,779,7358,1748,7135,5697,7772,3825,630,1780,6867,6575,5676,5833,6729,3889,326,4434,3364,1620,2760,4642,8513,7542,9048,492,2961,9168,4409,4519,4519,9455,8010,9055,1874,307,690,8428,1304,1449,34,6457,8643,6617,6254,4309,9946,3132,2044,233,7241,6375,5364,4348,3630,2983,6070,9579,3127,4451,4521,8202,6712,2264,8928,1865,9833,5451,9577,6615,8138,1567,2349,3459,7648,2486,943,9284,5501,5501,5501,5501,2724,7112,7105,2605,238,4145,794,3520,1158,9351,7743,7489,1393,3482,106,8145,2193,8905,7032,5173,6664,5302,5903"));
	}

	@Test
	public void testString9() {
		assertEquals(16, 
        sValValue("4574,4574,4574,4574,6654,8614,1026,5241,8050,1254,3927,9019,9054,9994,6266,3550,4737,3573,7754,8709,601,6325,8635,6575,4058,1391,4133,1992,7639,2087,8317,7569,9720,9448,7659,6596,580,7697,5397,4130,7097,7097,7097,7097,1528,6220,2798,8931,3842,6562,5113,1184,1578,7432,4389,1697,1697,1697,1697,5821,5821,1992,6232,7402,3272,3894,9357,6127,644,6998,7265,9463,1041,813,4089,9972,6408,1364,4771,151,2484,4490,8953,5715,7568,4649,9695,5359,6499,3707,2714,6129,8786,9063,9063,9063,9063,7392,2301,6682,3789,2903,1067,9849,5557,3859,7073,7073,1419,3340,7134,5437,8506,8506,8506,8506,9955,7999,7603,9488,2069,8890,6386,6707,2978,5655,8404,525,3103,4798,4798,5107,572,5287,5951,5951,5951,290,805,4811,9490,8694,1492,5264,3381,4332,2697,7726,9061,276,3640,3640,3566,7438,378,1566,1566,254,4005,7327,9373,8035,5640,2557,5793,1375,3728,8807,6301,3552,6193,1087,391,2534,227,7107,747,7701,6546,4194,6783,6687,6314,1627,1484,405,5975,831,8138,3266,3827,2594,821,5226,5226,5226,4377,4769,4769,4769,4769,5510,5510,5510,5510,6581,1344,8958,952,4033,7229,3955,3550,7557,968,3231,8914,8914,2681,2076,6875,2843,3011,9037,154,1741,5497,8928,2583,2785,8892,6714,2674,2667,5268,5268,8706,9494,8379"));
	}

	@Test
	public void testString10() {
		assertEquals(5, 
        sValValue("1633,4387,2347,2347,2347,7163,9406,5028,9001,8860,4446,5882,2887,2887,5658,9635,8956,9122,4434,9463,9463,2767,7672,7672,7672,2155,9595,3717,2473,2216,6477,6856,6710,827,827,827,978,8373,409,5809,7657,8255,1740"));
	}

}