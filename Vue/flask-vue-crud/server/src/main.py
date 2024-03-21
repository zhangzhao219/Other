import random
import numpy as np
import pandas as pd
from src.model import LightXML
from torch.utils.data import DataLoader
import torch
from src.dataset import MDataset

np.random.seed(6088)
random.seed(6088)
torch.manual_seed(6088)


label_map = {'公民道德与伦理常识': 16, '社会主义市场经济的伦理要求': 65, '现代史': 53, '文艺的春天': 46, '劳动就业与守法经营': 25, '生物科学与社会': 63, '避孕的原理和方法': 87, '伴性遗传': 12, '遗传的分子基础': 85, '遗传的细胞基础': 86, '人工授精、试管婴儿等生殖技术': 11, '生物性污染': 60, '现代生物技术专题': 54, '生物技术在其他方面的应用': 61, '稳态与环境': 69, '内环境的稳态': 19, '生命活动离不开细胞': 56, '减数分裂的概念': 23, '细胞有丝分裂不同时期的特点': 74, '减数分裂与有丝分裂的比较': 22, '宇宙中的地球': 43, '地球运动的地理意义': 32, '古代史': 26, '中央官制——三公九卿制': 3, '郡县制': 88, '“重农抑商”政策': 0, '夏商两代的政治制度': 41, '皇帝制度': 64, '生产活动与地域联系': 55, '工业区位因素': 44, '近代史': 82, '第三产业的兴起和“新经济”的出现': 70, '垄断组织的出现': 34, '神经调节和体液调节的比较': 67, '生物技术实践': 62, '生物工程技术': 59, '遗传与进化': 84, '拉马克的进化学说': 45, '分子与细胞': 24, '溶酶体的结构和功能': 51, '与细胞分裂有关的细胞器': 2, '高尔基体的结构和功能': 89, '中心体的结构和功能': 4, '液泡的结构和功能': 49, '内质网的结构和功能': 20, '核糖体的结构和功能': 47, '走进细胞': 81, '人体免疫系统在维持稳态中的作用': 5, '免疫系统的功能': 14, '体液免疫的概念和过程': 13, '免疫系统的组成': 15, '科学社会主义常识': 68, '社会主义是中国人民的历史性选择': 66, '复等位基因': 40, '基因工程的概念': 37, '基因工程的原理及技术': 36, '人口与城市': 8, '人口增长与人口问题': 9, '基因的分离规律的实质及应用': 38, '海峡两岸关系的发展': 48, '胚胎移植': 78, '器官移植': 27, '选官、用官制度的变化': 83, '地球的外部圈层结构及特点': 31, '地球的内部圈层结构及特点': 30, '地球运动的基本形式': 33, '组成细胞的化学元素': 72, '组成细胞的化合物': 71, '农业区位因素': 21, '地球所处的宇宙环境': 29, '细胞大小与物质运输的关系': 73, '兴奋在神经元之间的传递': 17, '兴奋在神经纤维上的传导': 18, '蛋白质的合成': 79, '人体的体温调节': 7, '人体水盐平衡调节': 6, '血糖平衡的调节': 80, '不完全显性': 1, '培养基与无菌技术': 35, '基因的自由组合规律的实质及应用': 39, '太阳对地球的影响': 42, '清末民主革命风潮': 50, '细胞的多样性和统一性': 75, '激素调节': 52, '生态系统的营养结构': 57, '生活中的法律常识': 58, '群落的结构': 77, '人口迁移与人口流动': 10, '地球与地图': 28, '经济学常识': 76}

index_map = {v: k for k, v in label_map.items()}

model = LightXML(n_labels=len(label_map), bert='ernie')
model.load_state_dict(torch.load(f'models/model-questions.bin',map_location=torch.device('cpu')))

def process(texts):
    return_list = []
    df_row = {'text': [texts], 'label': [''], 'dataType': ['test']}
    df = pd.DataFrame(df_row)
    # print(df)
    testloader = DataLoader(MDataset(df, 'test', model.get_fast_tokenizer(), label_map,max_length=512),num_workers=0, shuffle=False)
    pred_scores, pred_labels = model.one_epoch(0, testloader, None, mode='test')
    for i in range(len(pred_scores[0])):
        if pred_scores[0][i] > 0:
            return_list.append(index_map[i])
    return return_list
